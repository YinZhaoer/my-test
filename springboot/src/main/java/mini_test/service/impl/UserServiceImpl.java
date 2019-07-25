package mini_test.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mini_test.model.entity.UserInfoEntity;
import mini_test.repository.UserInfoRepository;
import mini_test.util.ResultMsg;
import mini_test.service.UserService;
import mini_test.util.JwtUtil;
import mini_test.util.verification_code.VerificationCodeUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: ZhaoYin
 * Date: 2019/7/22
 * Time: 15:57
 * Created with IntelliJ IDEA
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private final JwtUtil jwtUtil;
    private final PropertiesServiceImpl propertiesServiceImpl;
    private final UserInfoRepository userInfoRepository;
    private final VerificationCodeUtil verificationCodeUtil;

    @Autowired
    public UserServiceImpl(JwtUtil jwtUtil, PropertiesServiceImpl propertiesServiceImpl, UserInfoRepository userInfoRepository, VerificationCodeUtil verificationCodeUtil) {
        this.jwtUtil = jwtUtil;
        this.propertiesServiceImpl = propertiesServiceImpl;
        this.userInfoRepository = userInfoRepository;
        this.verificationCodeUtil = verificationCodeUtil;

    }

    private Map dataMap = new HashMap();

    private ResultMsg resultMsg = new ResultMsg();


    public ResultMsg loginWithoutToken(String phoneNumber, String verificationCode, HttpServletRequest request) throws Exception {
        String verificateionResponse = verificationCodeUtil.verifyCode(phoneNumber, verificationCode);
        JSONObject jsonObject = JSON.parseObject(verificateionResponse);
        if (Integer.valueOf((Integer) jsonObject.get("code"))==200) {
            if (userInfoRepository.existsByPhoneNumber(phoneNumber)) {
                UserInfoEntity userInfoEntity = userInfoRepository.findByPhoneNumber(phoneNumber);
                String jws = jwtUtil.createJWT(userInfoEntity.getUserId(),"sss",1000000);
                dataMap.put("jws", jws);
                dataMap.put("userInfo", userInfoEntity);
                resultMsg.success("登陆成功");
                resultMsg.setData(dataMap);
            } else {
                //跳转到注册界面调用注册接口
                dataMap.put("phoneNumber", phoneNumber);
                resultMsg.success("请注册");
            }

        } else
            resultMsg.failure("验证码错误");

        return resultMsg;
    }

    public ResultMsg loginWithToken(HttpServletRequest request) {
        String clientJws = request.getHeader("Authorization");
        if (clientJws != null) {
            clientJws = clientJws.substring(7);
            if (jwtUtil.validateJws(clientJws)) {
                Jws<Claims> claims = Jwts.parser().setSigningKey(propertiesServiceImpl.getKey()).parseClaimsJws(clientJws);
                //使用userId作为jws中payload的信息
                String userId = claims.getBody().getId();
                resultMsg.success(userInfoRepository.findByUserId(userId));
            } else {
                resultMsg.failure("jws验证失败");
            }
        }
        return resultMsg;
    }

    @Override
    public ResultMsg getDetail(String userId, HttpServletRequest request) {
        return resultMsg.success(userInfoRepository.findByUserId(userId));
    }

    @Override
    public ResultMsg register(UserInfoEntity userInfoEntity) {
        userInfoRepository.saveAndFlush(userInfoEntity);
        return resultMsg.success(userInfoEntity);
    }

    @Override
    public ResultMsg sendCode(String phoneNumber) {
        try {
            String codeResponse = verificationCodeUtil.sendCode(phoneNumber);
            resultMsg.success(JSONObject.parseObject(codeResponse));
        } catch (Exception e) {
            resultMsg.failure("发送验证码异常");
        }
        return resultMsg;
    }

    @Override
    public ResultMsg loginOut() {
        //清除jws并跳转到登陆界面
        return resultMsg.success("退出登陆");
    }
}
