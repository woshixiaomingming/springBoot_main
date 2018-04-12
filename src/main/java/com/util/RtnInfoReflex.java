package com.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * 对返回结果进行反射
 */
@Component
public class RtnInfoReflex {

    private static Logger logger = Logger.getLogger(RtnInfoReflex.class);

    /**
     * 使用反射去copy值达到当前想要获取的对象
     * @param classEntity  --面对接口的类
     * @param targetClassEntity --面对数据库的类
     * @param <T>
     * @return
     */
    public <T> T getRtnInfo (Class<T>classEntity, Class<T> targetClassEntity, Bean bean) {
        try {
            JSONObject json = new JSONObject();
            Field[] fields = classEntity.getDeclaredFields();
            Field[] targetFields = targetClassEntity.getDeclaredFields();
            T object = classEntity.newInstance();
            for (Field field : fields) {
                for (Field targetField : fields) {
                    if (field.getName().equals(targetClassEntity.getName())) {
                        field.setAccessible(true);

                        field.set(object, result.get(field.getName()));
                    }
                }
            }
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("反射当前的类赋值异常：" + e);
            return null;
        }
    }

}
