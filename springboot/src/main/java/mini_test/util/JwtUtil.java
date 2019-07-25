package mini_test.util;

/**
 * Author: ZhaoYin
 * Date: 2019/7/23
 * Time: 9:31
 * Created with IntelliJ IDEA
 * Description: Jwt工具类
 */


import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtUtil {
    private static final String issuer="babao";

    //秘钥Key
    private static final String JWTKey = "022bdc63c3c5a45879ee6581508b9d03adfec4a4658c0ab3d722e50c91a351c42c231cf43bb8f86998202bd301ec52239a74fc0c9a9aeccce604743367c9646b";

    private static SecretKey secretKey() {
        byte[] encodedKey = Base64.decodeBase64(JWTKey);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }


    /**
     * JWT创建函数
     *
     * @param id        JWTid
     * @param issuer    JWT签发人
     * @param subject   JWT所有人信息
     * @param ttlMillis JWT过期时间
     * @return JWT
     * @throws Exception JWT创建异常
     */
    public static String createJWT(String id, String subject, long ttlMillis) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date nowDate = new Date(nowMillis);

        Map<String, Object> claims = new HashMap<>();


        SecretKey secretKey = secretKey();

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(id)
                .setIssuer(issuer)
                .setIssuedAt(nowDate)
                .setSubject(subject)
                .signWith(signatureAlgorithm, secretKey);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }

        return builder.compact();
    }

    public boolean validateJws(String jws) {
        try {
            Jwts.parser().setSigningKey(JWTKey).parseClaimsJws(jws);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtException("Expired or invalid JWT token");
        }
    }


}


