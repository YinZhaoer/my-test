package mini_test.util.agora_token.dependencies.io.agora.rtm;


import mini_test.util.agora_token.dependencies.io.agora.media.AccessToken;

public class RtmTokenBuilder {
    public AccessToken mTokenCreator;

    public RtmTokenBuilder(String appId, String appCertificate, String userId) {
        mTokenCreator = new AccessToken(appId, appCertificate, userId, "");
    }

    public boolean initTokenBuilder(String originToken) {
        mTokenCreator.fromString(originToken);
        return true;
    }

    public void setPrivilege(AccessToken.Privileges privilege, int expireTimestamp) {
        mTokenCreator.message.messages.put(privilege.intValue, expireTimestamp);
    }

    public void removePrivilege(AccessToken.Privileges privilege) {
        mTokenCreator.message.messages.remove(privilege.intValue);
    }

    public String buildToken() throws Exception {
        return mTokenCreator.build();
    }

    public static void main(String[] args) {
        RtmTokenBuilder rtmTokenBuilder=new RtmTokenBuilder("eqw132131","qweqweqweqwe","qweqwe");
        try {
            String token=rtmTokenBuilder.buildToken();
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
