package mini_test.util;

import mini_test.util.ffpeg.Pic2VideoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ZhaoYin
 * Date: 2019/8/12
 * Time: 9:43
 * Created with IntelliJ IDEA
 * Description:
 */
public class FfmpegUtil {
    public static void main(String[] args) {
        Pic2VideoUtil pic2VideoUtil = new Pic2VideoUtil();
        String ffmpegPath = "E:\\ffmpeg-20190812-9fdc7f1-win64-static\\ffmpeg-20190812-9fdc7f1-win64-static\\bin\\ffmpeg.exe";
        Integer threads = 1;
        Integer timeLimit = 1000;
        String vedioOutPath="D:\\ffmpegTest\\output.avi";
        List<String> pathList = new ArrayList<>();
        pathList.add("D:\\imgtest\\0dcd857a30ec80a41cad783218ec9848.jpg");
        pathList.add("D:\\imgtest\\1b400479c88115fe60e6fbadfd6f757c.jpg");
        pathList.add("D:\\imgtest\\5fdcde3dc7a0235d87005df1b0bf9272.jpg");
        pathList.add("D:\\imgtest\\b391c80c9f1305c8a5cb88eb657e3eff.jpg");
        String ConcatFile = pic2VideoUtil.writeConcatFile("D:\\ffmpegTest", pathList);
        pic2VideoUtil.picsToVideoWithConcat(ffmpegPath,threads,timeLimit,ConcatFile,null,vedioOutPath);
        System.out.println("asds");
//        pic2VideoUtil.picsToVideoWithConcat(ffmpegPath, threads, timeLimit, ConcatFile, );
    }
}
