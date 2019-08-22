package mini_test.util.ffpeg;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: wangchao3
 * @date: 2019/8/7
 * @description:
 */
@Slf4j
public class PicUtil {


    /**
     * 图片压缩
     * @param srcPath 源文件路径
     * @param desPath 目标文件路径
     * @param desFileSize 目标文件大小
     * @param accuracy 压缩精度0-1，精度越大越高清
     * @return
     */
    public static void compressPicForScale(String srcPath, String desPath,
                                              long desFileSize, double accuracy) {
        if (srcPath == null||desPath == null || srcPath.isEmpty()||desPath.isEmpty()) {
            return;
        }
        if (!new File(srcPath).exists()) {
            return;
        }
        try {
            File srcFile = new File(srcPath);
            long srcFileSize = srcFile.length();
            log.info("源图片：" + srcPath + "，大小：" + srcFileSize / 1024 + "kb");
            //获取图片信息
            BufferedImage bim = ImageIO.read(srcFile);
            int srcWidth = bim.getWidth();
            int srcHeight = bim.getHeight();
            //先转换成jpg
            Thumbnails.Builder builder = Thumbnails.of(srcFile).outputFormat("jpg");
            builder.size(srcWidth,srcHeight);

            // 写入到内存
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); //字节输出流（写入到内存）
            builder.toOutputStream(baos);
            // 递归压缩，直到目标文件大小小于desFileSize
            byte[] bytes = commpressPicCycle(baos.toByteArray(), desFileSize, accuracy);
            // 输出到文件
            File desFile = new File(desPath);
            FileOutputStream fos = new FileOutputStream(desFile);
            fos.write(bytes);
            log.info("图片压缩完成,目标图片：" + desPath + "，大小" + desFile.length() / 1024 + "kb");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("图片压缩发生异常，图片路径:"+srcPath,e);
        }
    }

    private static byte[] commpressPicCycle(byte[] bytes, long desFileSize, double accuracy) throws IOException {
        // File srcFileJPG = new File(desPath);
        long srcFileSizeJPG = bytes.length;
        // 2、判断大小，如果小于500kb，不压缩；如果大于等于500kb，压缩
        if (srcFileSizeJPG <= desFileSize * 1024) {
            return bytes;
        }
        // 计算宽高
        BufferedImage bim = ImageIO.read(new ByteArrayInputStream(bytes));
        int srcWdith = bim.getWidth();
        int srcHeigth = bim.getHeight();
        int desWidth = new BigDecimal(srcWdith).multiply(
                new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(srcHeigth).multiply(
                new BigDecimal(accuracy)).intValue();
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //字节输出流（写入到内存）
        Thumbnails.of(new ByteArrayInputStream(bytes)).size(desWidth, desHeight).outputQuality(accuracy).toOutputStream(baos);
        return commpressPicCycle(baos.toByteArray(), desFileSize, accuracy);
    }



    public static void main(String[] args) {
        String srcPath = "D:\\image\\compress\\test.jpg";
        String decPath = "D:\\image\\compress\\out.jpg";
        long start = new Date().getTime();
        compressPicForScale(srcPath,decPath,600,0.2);
        long end = new Date().getTime();
        System.out.println("花费时间："+(end-start)/1000+"秒");

    }
}
