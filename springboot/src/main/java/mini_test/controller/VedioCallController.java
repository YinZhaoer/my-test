package mini_test.controller;

import mini_test.service.VedioCallService;
import mini_test.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ZhaoYin
 * Date: 2019/7/26
 * Time: 11:03
 * Created with IntelliJ IDEA
 * Description:
 */
@RestController
@RequestMapping("/vedioCall/")
public class VedioCallController {
    private final VedioCallService vedioCallService;

    @Autowired
    public VedioCallController(VedioCallService vedioCallService){
        this.vedioCallService=vedioCallService;
    }


    @RequestMapping("/getToken")
    public ResultMsg getToken() throws Exception {
        return  vedioCallService.getAgoraToken();
    }

}
