package mini_test.util.agora_token;

import mini_test.util.agora_token.dependencies.io.agora.media.AccessToken;
import mini_test.util.agora_token.dependencies.io.agora.rtm.RtmTokenBuilder;

/**
 * Author: ZhaoYin
 * Date: 2019/7/25
 * Time: 20:10
 * Created with IntelliJ IDEA
 * Description:
 */
public class AgoraTokenUtil {
    static String appId = "970CA35de60c44645bbae8a215061b33";
    static String appCertificate = "5CFd2fd1755d40ecb72977518be15d3b";
    static String userId = "2882341273";
    static int expireTimestamp = 0;

    public static void main(String[] args) throws Exception {
        RtmTokenBuilder token = new RtmTokenBuilder(appId, appCertificate, userId);
        token.setPrivilege(AccessToken.Privileges.kRtmLogin, expireTimestamp);
        String result = token.buildToken();
        System.out.println(result);
    }
}
