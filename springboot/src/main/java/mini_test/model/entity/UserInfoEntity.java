package mini_test.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: ZhaoYin
 * Date: 2019/7/24
 * Time: 11:15
 * Created with IntelliJ IDEA
 * Description: 对应user_info表的Entity类
 */

@Entity
@Data
@Table(name = "user_info")
public class UserInfoEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private Integer userRole;

    @Column(name = "phone_number")
    private String phoneNumber;

    public UserInfoEntity(){}

}

