package mini_test.util;

/**
 * Author: ZhaoYin
 * Date: 2019/7/23
 * Time: 9:31
 * Created with IntelliJ IDEA
 * Description: Jwt工具类
 */


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtUtil {

    @Value("${jwt.key}")
    private String key;

    public String createJws(String info) {
        String jws = Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("type", "jwt")
                .setId(info)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
        return jws;
    }

    public boolean validateJws(String jws) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(jws);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtException("Expired or invalid JWT token");
        }
    }


}


