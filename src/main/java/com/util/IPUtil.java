package com.util;

import com.common.Page;
import com.controller.Base;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.net.URL;

public class IPUtil {

    private static Logger logger = Logger.getLogger(IPUtil.class);

    public static String getIP (Page page) {
        String ip = page.getRequest().getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = page.getRequest().getHeader("X-Forwarded-For");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = page.getRequest().getHeader("X-Real-IP"); // 获取代理ip
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = page.getRequest().getRemoteAddr(); // 获取真实ip
        }

        if(ip.indexOf(",") >= 0){
            //log.error("x-forwarded-for:" + ip + ",");
            String[] ips = ip.split(",");
            for(int i = 0; i < ips.length; i++){
                ip = ips[i];
                if(!"".equals(ip) && !"unknown".equalsIgnoreCase(ip) && !"127.0.0.1".equals(ip))
                    break;
            }
        }
        return ip;
    }

    /**
     * 获取referer中的信息防范crsf攻击
     * @return
     */
    public static boolean getReferer () {
        Page page = Base.get();
        String referer = page.getRequest().getHeader("Referer");
        String ip = getIP(page);
        if (StringUtils.isBlank(referer) && !ip.equals("127.0.0.1")) {
            logger.error("非法referer，可能的csrf攻击，来源ip为：" + ip);
            return false;
        }
        //判断域名是否是指定域名下的请求
        URL url = null;
        try {
            url = new URL(referer);
            if (url.getHost().equals(MainGlobalConfig.getValue("referer_main"))) {
                return true;
            } else {
                logger.error("非法referer，可能的csrf攻击，来源ip为：" + ip);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("referer判断出现异常：" + e);
            return false;
        }
    }
}
