package mini_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ZhaoYin
 * Date: 2019/8/13
 * Time: 20:41
 * Created with IntelliJ IDEA
 * Description:
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/redis")
    public void testRedis(){
        redisTemplate.opsForValue().set("zhaoyin","heheheh");
        String s= (String) redisTemplate.opsForValue().get("zhaoyin");
        Object obj=redisTemplate.opsForValue().get("c_s:I006405418");
        System.out.println(s);
        System.out.println(obj.toString());
    }
}
