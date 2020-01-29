package mini_test.util;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: ZhaoYin
 * Date: 2019/8/1
 * Time: 16:57
 * Created with IntelliJ IDEA
 * Description: Cookie相关操作单元
 */
@Component
public class CookieUtil {

    /**
     * 移除所有cookie
     *
     * @param request
     * @param response
     * @return
     */
    public static boolean removeAllCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                return true;
            }

        }
        return false;
    }

    /**
     * 移除名称为name的cookie
     *
     * @param request
     * @param response
     * @param name
     * @return
     */
    public static boolean removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        if (StringUtils.isBlank(name)) {
            return false;
        }
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * 新增Cookie,设置过期时间小于0就永久保持
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @return
     */
    public static boolean addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(value)) {
            return false;
        }
        Cookie cookie = new Cookie(name.trim(), value.trim());
        if (maxAge <= 0) {
            maxAge = Integer.MAX_VALUE;
        }
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }
}
