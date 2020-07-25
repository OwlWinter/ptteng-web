package cn.mogeek.rmi.ptteng.client.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName UserToken
 * @Description 生成 jwt
 * @Author owlwinter
 * @Date 2020/7/19 13:28
 * @Version 1.0
 **/
@Component
public class UserToken {

    private static SecretKey SECRET_KEY = new SecretKeySpec("6603_8415_66033_1527495_54_67654".getBytes(), SignatureAlgorithm.HS512.getJcaName());
    private static long ISSUING_TIME = 600;

    /**
     * @Description: 生成 jwt
     * @Param: [info]
     * @return: java.lang.String
     * @Author: owlwinter
     * @Date: 2020/7/19
     */
    public static String generator(Map<String, Object> info){
        info.put("EXPIRATION", ISSUING_TIME);

        return Jwts.builder()
                .setClaims(info)
                .setExpiration(new Date(System.currentTimeMillis() + (ISSUING_TIME * 1000)))
                .signWith(SECRET_KEY)
                .compact();
    }

    /**
     * @Description: 校验是否被篡改
     * @Param: [jwt]
     * @return: boolean
     * @Author: owlwinter
     * @Date: 2020/7/19
     */
    public static boolean verifyToke(String jwt){
        if (jwt == null || jwt == ""){ return false; }

        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(jwt);

            return true;
        } catch (JwtException e){
            e.printStackTrace();
        }

        return false;
    }

    /**
     * @Description: 获取载荷信息
     * @Param: [jwt]
     * @return: java.lang.String
     * @Author: owlwinter
     * @Date: 2020/7/19
     */
    public static String parser(String jwt){
        if (jwt == null || jwt == "") { return null; }

        String playload = jwt.split("\\.")[1];
        return new String(Base64.getUrlDecoder().decode(playload));
    }

}
