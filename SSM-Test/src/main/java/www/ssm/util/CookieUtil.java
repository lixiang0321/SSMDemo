package www.ssm.util;


import www.ssm.util.sercurity.TestMD5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class CookieUtil {
    private CookieUtil() {}
    public static void set(String name, String value, HttpServletResponse resp) {// value = mid:password
        String val = TestMD5.BaseMD5(value) ; // 将数据内容进行加密存储
        Cookie c = new Cookie(name,val) ; // 创建Cookie的对象
        c.setPath("/"); // 设置目录
        c.setMaxAge((int)TimeUnit.SECONDS.convert(30,TimeUnit.DAYS));
        resp.addCookie(c); // 保存Cookie数据
    }
    //根据注册的info信息进行获取密码
    public static String get(String name, HttpServletRequest req) {
        Cookie cookie [] = req.getCookies() ; // 获取全部的Cookie内容
        //如果cookile不等于NULL
        if (cookie != null) {
            //遍历每一个cookie
            for (int x = 0 ; x < cookie.length ; x ++) {
                //如果当前的name在全部的cookile中有存储
                if (name.equalsIgnoreCase(cookie[x].getName())) {
                    //同时判断根据当前的name获取到的value不等于null
                    if (!"".equals(cookie[x].getValue())) {
//                        return EncryptSalt.decrypt(cookie[x].getValue());
                        //返回当前的value
                        return cookie[x].getValue();
                    }
                }
            }
        }
        return null ;
    }
    public static void clean(HttpServletResponse resp,String ... key) {
        for (String name : key) {
            Cookie c = new Cookie(name,"") ; // 创建Cookie的对象
            c.setPath("/"); // 设置目录
            resp.addCookie(c);
        }
    }
}

