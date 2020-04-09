package com.iot.util;

import org.springframework.util.ObjectUtils;

/**
 * @author: weiyunyun
 * @date: 2020/4/8 14:33
 */
public class ParamaterJudgeUtil {
    /**
     * 判断对象是否为空
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object){
        if (ObjectUtils.isEmpty(object)){
            return true;
        }
        return false;
    }

    /**
     * 判断两个对象是否相等
     * @param object1
     * @param object2
     * @return
     */
    public static boolean isEquals(Object object1,Object object2){
        if (ObjectUtils.nullSafeEquals(object1,object2)){
            return true;
        }
        return false;
    }
}
