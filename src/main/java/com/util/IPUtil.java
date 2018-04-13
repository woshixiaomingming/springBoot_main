package com.util;

import com.common.Page;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {

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
}
