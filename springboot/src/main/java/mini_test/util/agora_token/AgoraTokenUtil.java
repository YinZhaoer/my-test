package mini_test.util.agora_token;

import mini_test.util.agora_token.dependencies.io.agora.media.AccessToken;
import mini_test.util.agora_token.dependencies.io.agora.rtm.RtmTokenBuilder;
import org.springframework.stereotype.Component;

/**
 * Author: ZhaoYin
 * Date: 2019/7/25
 * Time: 20:10
 * Created with IntelliJ IDEA
 * Description:
 */
@Component
public class AgoraTokenUtil {

    public String createRtmToken(String appId, String appCertificate, String userId, int expireTimestamp) throws Exception {
        RtmTokenBuilder token = new RtmTokenBuilder(appId, appCertificate, userId);
        token.setPrivilege(AccessToken.Privileges.kRtmLogin, expireTimestamp);
        String result = token.buildToken();
        return result;
    }

}
