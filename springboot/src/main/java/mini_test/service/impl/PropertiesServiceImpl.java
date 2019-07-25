package mini_test.service.impl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Author: ZhaoYin
 * Date: 2019/7/23
 * Time: 10:35
 * Created with IntelliJ IDEA
 * Description: 配置信息类
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class PropertiesServiceImpl {

    private String key;

}
