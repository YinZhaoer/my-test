package mini_test.service.impl;

import mini_test.service.VedioCallService;
import mini_test.util.ResultMsg;
import mini_test.util.agora_token.AgoraTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: ZhaoYin
 * Date: 2019/7/26
 * Time: 11:20
 * Created with IntelliJ IDEA
 * Description:
 */
@Component
public class VedioCallServiceImpl implements VedioCallService {
    private final AgoraTokenUtil agoraTokenUtil;

    @Autowired
    public VedioCallServiceImpl(AgoraTokenUtil agoraTokenUtil){
        this.agoraTokenUtil=agoraTokenUtil;
    }


    @Override
    public ResultMsg getAgoraToken() {
        ResultMsg resultMsg = new ResultMsg();
        try {
            String agoraToken = agoraTokenUtil.createRtmToken("7fc4e801096041a297e1d4ab8e291cf0", "c9f075840f164a15974c671e3f4b3c04", "12354", 0);
            resultMsg.setMeta(new ResultMsg.Meta(true, "返回声网token"));
            resultMsg.setData(agoraToken);
        } catch (Exception e) {
            e.getMessage();
            resultMsg.setMeta(new ResultMsg.Meta(false, e.getMessage()));
        }
        return resultMsg;

    }
}
