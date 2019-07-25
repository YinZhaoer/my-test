package mini_test.util.verification_code;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: qdh
 * Date: 2019/7/23
 * Time: 16:22
 * Created with IntelliJ IDEA
 * Description:
 */
@Component
public class VerificationCodeUtil {
    //发送验证码的请求路径URL
    private static final String
            SERVER_SEND_URL = "https://api.netease.im/sms/sendcode.action";
    //验证验证码的请求路径URL
    private static final String
            SERVER_VERIFY_URL = "https://api.netease.im/sms/verifycode.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String
            APP_KEY = "c858f632ebaaf1fc8cd31339ead5aaa0";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET = "40966ccbedd6";
    //随机数
    private static final String NONCE = "123456";
    //短信模板ID
    private static final String TEMPLATEID = "14798536";
    //手机号
    private static final String MOBILE = "17718152780";
    //验证码长度，范围4～10，默认为4
    private static final String CODELEN = "4";

    public HttpPost getHttpPost(String serverUrl ) throws Exception {
        HttpPost httpPost = new HttpPost(serverUrl);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
        // 设置请求的header
        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        return httpPost;
    }
    // 发送验证码
    public String sendCode(String phoneNumber) throws Exception {
        HttpPost httpPost =getHttpPost(SERVER_SEND_URL);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
        nvps.add(new BasicNameValuePair("mobile", phoneNumber));
        nvps.add(new BasicNameValuePair("codeLen", CODELEN));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        return getResponse(httpPost);
    }

    public String verifyCode(String phoneNumber,String code) throws Exception {
        //得到发送的httpPost
        HttpPost httpPost =getHttpPost(SERVER_VERIFY_URL);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("mobile", phoneNumber));
        nvps.add(new BasicNameValuePair("code", code));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        return  getResponse(httpPost);
    }

    // httpClint 发送请求得到返回值
    public  String getResponse(HttpPost httpPost) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpPost);
        return  EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public static void main(String[] args) throws Exception {
        VerificationCodeUtil verificationCodeUtil = new VerificationCodeUtil();
//        String response = sendCode.sendCode("17718152780");
//        System.out.println(response);
        String result = verificationCodeUtil.verifyCode("17718152780","8207");
        System.out.println(result);
    }
}