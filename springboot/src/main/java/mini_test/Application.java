package mini_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import mini_test.service.impl.PropertiesServiceImpl;

/**
 * Author: ZhaoYin
 * Date: 2019/7/22
 * Time: 17:15
 * Created with IntelliJ IDEA
 * Description: 启动类
 */
@SpringBootApplication
@EnableConfigurationProperties({PropertiesServiceImpl.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
