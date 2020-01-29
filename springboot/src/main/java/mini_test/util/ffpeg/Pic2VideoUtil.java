package mini_test.util.ffpeg;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author: wangchao3
 * @date: 2019/8/1
 * @description:
 */
@Slf4j
@Component
public class Pic2VideoUtil {


    @Autowired
    private FfmpegConfig ffmpegConfig;

    private static final String CONCAT_FILE_PATH_FORMAT = "file \'%s\'\n";
    private static final String CONCAT_DURATION_FORMAT = "duration %s\n";

    private static final String CONCAT_FILE_NAME = "input.txt";


    /**
     * 制作视频、上传NOS、Video对象存数据库
     * @param userId 用户ID
     * @param pathList 照片存储路径列表
     * @param bgmPath bgmc存储路径，可为null
     */
//    @Async
//    public void makeAndUploadFile(int userId, List<String> pathList, String bgmPath,Video video){
//        if(pathList == null || pathList.size()==0){
//            return;
//        }
//        String outputFileName = video.getPath().substring(video.getPath().lastIndexOf("/")+1);
//        String relativePath = video.getPath().substring(Mini9Constants.NOS_OBJECT_URL_HEAD.length());
//        long compressStart = new Date().getTime();
//        for (String path: pathList) {
//            //压缩输入输出路径一致，直接覆盖原始文件
//            PicUtil.compressPicForScale(
//                    path,
//                    path,
//                    ffmpegConfig.getImgCompressDesSize(),
//                    ffmpegConfig.getCompressAccuracy());
//        }
//        long compressEnd = new Date().getTime();
//        log.info(pathList.size()+"张图片压缩用时："+(compressEnd-compressStart)+"ms");
//        //制作视频，失败返回null
//        File videoFile = picsToVideo(userId,pathList,bgmPath,outputFileName);
//        if (videoFile == null){
//            video.setStatus(VideoStatus.FAILED.getCode());
//            videoMapper.updateByPrimaryKeySelective(video);
//            return;
//        }
//        //异步上传文件
//        nosService.uploadFile(videoFile, relativePath, true);
//        video.setStatus(VideoStatus.SUCCESS.getCode());
//        videoMapper.updateByPrimaryKeySelective(video);
//    }

    /**
     * 制作视频
     *
     * @param userId
     * @param pathList
     * @param bgmPath
     * @param outputFileName
     * @return 成功返回true, 失败false
     */
    private File picsToVideo(int userId, List<String> pathList, String bgmPath, String outputFileName) {

        String tempFilePath = ffmpegConfig.getTempFilePath() + userId;
        String concatFilePath = writeConcatFile(tempFilePath, pathList);
        File outputFile = new File(tempFilePath + File.separator + outputFileName);
        int timeLimit = pathList.size() * ffmpegConfig.getDuration();
        boolean transferResult = picsToVideoWithConcat(
                ffmpegConfig.getCommandPath(),
                ffmpegConfig.getThreads(),
                timeLimit,
                concatFilePath,
                bgmPath,
                outputFile.getAbsolutePath());
//        delete photos, after video generated
        for (String path : pathList) {
            File file = new File(path);
            file.delete();
        }

        return transferResult ? outputFile : null;
    }

    /**
     * 将图片路径写入concat文件
     *
     * @param tempFilePath
     * @param pathList
     * @return concat文件路径
     */
    public String writeConcatFile(String tempFilePath, List<String> pathList) {
        File tempFileDir = new File(tempFilePath);
        if (!tempFileDir.exists()) {
            tempFileDir.mkdir();
        }
        File inputFile = new File(tempFilePath + File.separator + CONCAT_FILE_NAME);
        StringBuilder sb = new StringBuilder();
        for (String path : pathList) {
            sb.append(String.format(CONCAT_FILE_PATH_FORMAT, path));
            sb.append(String.format(CONCAT_DURATION_FORMAT, ffmpegConfig.getDuration()));
        }
        sb.append(String.format(CONCAT_FILE_PATH_FORMAT, pathList.get(pathList.size() - 1)));
        if (inputFile.exists()) {
            inputFile.delete();
        }
        try {
            inputFile.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inputFile));
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputFile.getAbsolutePath();
    }


    public static void main(String[] args) {

        String ff = "E:\\ffmpeg-20190808-e317c25-win64-static\\bin\\ffmpeg";
        String con = "E:\\pic\\picUrl\\piclist.txt";
        String bgm = "E:\\music\\music.mp3";
        String out = " E:\\outMusic\\abc.avi";
        Pic2VideoUtil pic2VideoUtil = new Pic2VideoUtil();
        pic2VideoUtil.picsToVideoWithConcat(ff, 1, 5, con, bgm, out);


    }


    /**
     * @param ffmpegPath      Ffmpeg.exe文件路径，使用配置文件进行读取
     * @param threads         使用线程数
     * @param timeLimit       设置视频时长限制
     * @param concatFilePath  设置照片concat文件路径
     * @param bgmPath         设置bgm文件路径
     * @param videoOutputPath 设置视频生成路径
     */
    public boolean picsToVideoWithConcat(String ffmpegPath, int threads, int timeLimit, String concatFilePath, String bgmPath, String videoOutputPath) {
        // 构建命令
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-y");
        command.add("-threads");
        command.add(String.valueOf(threads));
        command.add("-f");
        command.add("concat");
        command.add("-safe");
        command.add("0");
        command.add("-i");
        command.add(concatFilePath);
        if (bgmPath != null && !bgmPath.isEmpty()) {
            command.add("-i");
            command.add(bgmPath);
//            command.add("-absf");
//            command.add("aac_adtstoasc");
        }
//        command.add("-vcodec");
//        command.add("libx264");
        command.add("-vf");
        command.add("pad=ceil(iw/2)*2:ceil(ih/2)*2");
        command.add("-t");
        command.add(String.valueOf(timeLimit));
        if (ffmpegConfig.getBitrate() != null) {
            command.add("-b");
            command.add(String.valueOf(ffmpegConfig.getBitrate()));
        }
        command.add(videoOutputPath);
        // 执行操作
        ProcessBuilder builder = new ProcessBuilder(command);
        int exitCode = 1;
        try {
            long makeStart = new Date().getTime();
            Process process = builder.start();
            recordProcessInfo(process);
            exitCode = process.waitFor();
            long makeEnd = new Date().getTime();
            log.info("制作视频耗时：" + (makeEnd - makeStart) + "ms");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            log.error("制作视频发生异常", e);
            return false;
        }
        return exitCode == 0;
    }

    /**
     * 读取进程信息流，记录日志
     *
     * @param process
     * @throws IOException
     */
    private void recordProcessInfo(Process process) throws IOException {

        if (process == null) {
            return;
        }
        InputStream errorStream = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append('\n');
        }
        if (sb.length() > 0) {
//            System.out.println(sb.toString());
            log.info(sb.toString());
        }

        br.close();
        isr.close();
        errorStream.close();
    }


}
