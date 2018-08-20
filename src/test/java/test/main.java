package test;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserDao;
import org.junit.Test;

public class main {

    UserDao userDao = new UserDao();

    @Test
    public void getinfo () {
        System.out.println(userDao.findUserById(1));


    }

}
