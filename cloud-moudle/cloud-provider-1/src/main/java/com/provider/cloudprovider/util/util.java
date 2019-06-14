package com.provider.cloudprovider.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @Author: carter
 * @Date: 2019/6/14 11:06
 * @Version 1.0
 */
@SuppressWarnings("Duplicates")
public class util {
    /**
     * 功能描述:
     * 〈校验字符串是否为正确的时间格式〉
     *
     * @Author: carter
     * @Date: 2019/6/14 11:06
     * @return: boolean
     */
    public static boolean isValidDate(String str) {
        boolean convertSuccess = false;
        /**指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            /**设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01*/
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            /** e.printStackTrace();*/
            /** 如果throw java.text.ParseException或者NullPointerException，就说明格式不对*/
            convertSuccess = true;
        }
        return convertSuccess;
    }

    /**
     * 处理时间格式
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getDatetime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime newDate = LocalDateTime.parse(localTime, df);
        return newDate;
    }

    /**
     * 判断数组中是否存在某值
     *
     * @param arr
     * @param targetValue
     * @return boolean
     */
    public static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    /**
     * 利用反射修改实体类中""为null
     *
     * @param obj
     * @return Object
     */
    public static Object checkNull(Object obj) {
        Class<? extends Object> clazz = obj.getClass();
        /**获取实体类的所有属性，返回Field数组*/
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            /** 可访问私有变量*/
            field.setAccessible(true);
            /**获取属性类型*/
            String type = field.getGenericType().toString();
            /**如果type是类类型，则前面包含"class "，后面跟类名*/
            if ("class java.lang.String".equals(type)) {
                /**将属性的首字母大写*/
                String methodName = field.getName().replaceFirst(field.getName().substring(0, 1),
                        field.getName().substring(0, 1).toUpperCase());
                try {
                    Method methodGet = clazz.getMethod("get" + methodName);
                    /**调用getter方法获取属性值*/
                    String str = (String) methodGet.invoke(obj);
                    if ("".equals(str)) {
                        /**Method methodSet = clazz.getMethod("set" + methodName, new Class[] { String.class });*/
                        /**methodSet.invoke(obj, null);*/
                        /**如果为""的String类型的属性则重新复制为null*/
                        field.set(obj, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

}
