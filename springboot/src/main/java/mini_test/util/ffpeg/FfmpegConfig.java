package mini_test.util.ffpeg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: wangchao3
 * @date: 2019/8/2
 * @description:
 */

@Component
@ConfigurationProperties(prefix = "ffmpeg")
public class FfmpegConfig {

    private String commandPath;
    private String tempFilePath;
    private String videoExtName;
    private Integer threads;
    private Integer fps;
    private Integer duration;
    private Integer bitrate;
    private Integer imgCompressDesSize;
    private Double compressAccuracy;
    private Integer compressWidth;
    private Integer compressHeight;

    public String getCommandPath() {
        return commandPath;
    }

    public void setCommandPath(String commandPath) {
        this.commandPath = commandPath;
    }

    public String getTempFilePath() {
        return tempFilePath;
    }

    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }

    public String getVideoExtName() {
        return videoExtName;
    }

    public void setVideoExtName(String videoExtName) {
        this.videoExtName = videoExtName;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    public Integer getFps() {
        return fps;
    }

    public void setFps(Integer fps) {
        this.fps = fps;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getBitrate() {
        return bitrate;
    }

    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }


    public Integer getImgCompressDesSize() {
        return imgCompressDesSize;
    }

    public void setImgCompressDesSize(Integer imgCompressDesSize) {
        this.imgCompressDesSize = imgCompressDesSize;
    }

    public Double getCompressAccuracy() {
        return compressAccuracy;
    }

    public void setCompressAccuracy(Double compressAccuracy) {
        this.compressAccuracy = compressAccuracy;
    }

    public Integer getCompressWidth() {
        return compressWidth;
    }

    public void setCompressWidth(Integer compressWidth) {
        this.compressWidth = compressWidth;
    }

    public Integer getCompressHeight() {
        return compressHeight;
    }

    public void setCompressHeight(Integer compressHeight) {
        this.compressHeight = compressHeight;
    }
}
