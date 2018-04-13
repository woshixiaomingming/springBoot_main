package com.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 对返回结果进行反射
 */
@Component
public class RtnInfoReflexUtil {

    private static Logger logger = Logger.getLogger(RtnInfoReflexUtil.class);

    /**
     * 使用反射去copy值达到当前想要获取的对象
     * @param classEntity  --面对接口的类
     * @param targetClassEntity --面对数据库的类
     * @param <T>
     * @return
     */
    public <T> T getRtnInfo (Class<T> classEntity, Object targetObject) {
        try {
            Field[] fields = classEntity.getDeclaredFields();
            Class<?> targetClasss = targetObject.getClass();
            Field[] targetFields = targetClasss.getDeclaredFields();
            T object = classEntity.newInstance();
            for (Field targetField : targetFields) {
                for (Field field : fields) {
                    if (field.getName().equals(targetField.getName())) {
                        //输入 -----获取get方法
                        PropertyDescriptor pds = new PropertyDescriptor(targetField.getName(), targetClasss);
                        Method methods = pds.getReadMethod();
                        Object getValue = methods.invoke(targetObject);

                        //输出 -----获取set方法
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), object.getClass());
                        Method method = pd.getWriteMethod();
                        method.invoke(object, getValue);
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
