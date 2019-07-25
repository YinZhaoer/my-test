package mini_test.repository;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mini_test.model.entity.UserInfoEntity;

/**
 * Author: ZhaoYin
 * Date: 2019/7/24
 * Time: 11:42
 * Created with IntelliJ IDEA
 * Description: user_info表操作接口
 */
@Repository
@Qualifier("UserInfoRepository")
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {

    UserInfoEntity findByUserId(String userId);

    UserInfoEntity findByPhoneNumber(String phoneNumber);

    UserInfoEntity saveAndFlush(UserInfoEntity userInfoEntity);

    boolean existsByPhoneNumber(String phoneNumber);






}