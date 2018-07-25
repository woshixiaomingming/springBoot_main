package com.main;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 知乎爬虫
 */
public class JsoupMain {

    @Test
    public void zhihuJsoup () {
        try {
            /*URL url = new URL("https://blog.csdn.net/wangpeng198688/article/details/51281638");
            SSLContext sslContext = SSLContext.getInstance("TLS");*/
            /*Document document = Jsoup.connect("https://blog.csdn.net/wangpeng198688/article/details/51281638").get();
            System.out.println(document);*/
            Connection con = Jsoup
                    .connect("https://www.zhihu.com");// 获取连接
            con.header("User-Agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/603.3.8 (KHTML, like Gecko) Version/10.1.2 Safari/603.3.80");// 配置模拟浏览器
            Connection.Response rs = con.execute();// 获取响应
            Document d1 = Jsoup.parse(rs.body());// 转换为Dom树
            System.out.println(d1);
            //List<Element> et = d1.select(".SignFlow");// 获取form表单，可以通过查看页面源码代码得知
            // 获取，cooking和表单属性，下面map存放post时的数据
            Map<String, String> datas = new HashMap<String, String>();
            //密码
            List<Element> etpassword = d1.select(".SignFlow-account");
            datas = getElment(datas, etpassword);
            //账号
            List<Element> etUsername = d1.select(".SignFlow-password");
            datas = getElment(datas, etUsername);
            Set<String> set = datas.keySet();
            for (String str : set) {
                System.out.println(datas.get(str));
            }


            /**
             * 第二次请求，post表单数据，以及cookie信息
             *
             * **/
            /*Connection con2 = Jsoup
                    .connect("https://www.zhihu.com");
            con2.header("User-Agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/603.3.8 (KHTML, like Gecko) Version/10.1.2 Safari/603.3.80");
            // 设置cookie和post上面的map数据
            Connection.Response login = con2.ignoreContentType(true).method(Connection.Method.POST)
                    .data(datas).cookies(rs.cookies()).execute();
            // 打印，登陆成功后的信息
            System.out.println(login.body());
            // 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
            Map<String, String> map = login.cookies();
            for (String s : map.keySet()) {
                System.out.println(s + "      " + map.get(s));
            }
            Document doc = Jsoup.connect("https://www.zhihu.com").post();
            System.out.println(doc);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getElment (Map<String, String> datas, List<Element> et) {
        for (Element e : et.get(0).getAllElements()) {
            if (e.attr("name").equals("username")) {
                e.attr("value", "13928462527");// 设置用户名
            }
            if (e.attr("name").equals("password")) {
                e.attr("value", "tgmmaomaoshizhu1"); // 设置用户密码
            }
            if (e.attr("name").length() > 0) {// 排除空值表单属性
                datas.put(e.attr("name"), e.attr("value"));
            }
        }
        return datas;
    }

}
