package mini_test.service;

import mini_test.model.entity.UserInfoEntity;
import mini_test.util.ResultMsg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    ResultMsg loginWithoutToken(String phoneNumber, String verificationCode, HttpServletRequest request,HttpServletResponse response) throws Exception;

    ResultMsg loginWithToken(HttpServletRequest request);

    ResultMsg getDetail(String userId, HttpServletRequest request);

    ResultMsg register(UserInfoEntity userInfoEntity);

    ResultMsg sendCode(String phoneNumber);

    ResultMsg loginOut();



}
