package mini_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mini_test.model.entity.UserInfoEntity;
import mini_test.service.UserService;
import mini_test.util.ResultMsg;

import javax.servlet.http.HttpServletRequest;


/**
 * Author: ZhaoYin
 * Date: 2019/7/22
 * Time: 15:56
 * Created with IntelliJ IDEA
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/login/withoutToken")
    public ResultMsg loginWithouttoken(@RequestParam String phoneNumber, @RequestParam String verificationCode, HttpServletRequest request) throws Exception {
        return userService.loginWithoutToken(phoneNumber, verificationCode, request);
    }

    @RequestMapping("/login/getInfo")
    public ResultMsg getDetail(@RequestParam String userId, HttpServletRequest request) {
        return userService.getDetail(userId,request);
    }

    @RequestMapping("/login/withToken")
    public ResultMsg loginWithToken(HttpServletRequest request){
        return userService.loginWithToken(request);
    }

    @RequestMapping("/register")
    public ResultMsg register(@RequestBody UserInfoEntity userInfoEntity){
        return userService.register(userInfoEntity);
    }

    @RequestMapping("/sendCode")
    public ResultMsg sendCode(@RequestParam String phoneNumber){
        return userService.sendCode(phoneNumber);

    }


}
