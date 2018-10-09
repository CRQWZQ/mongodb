package com.metabolic.mongodb.untils;

/**
 * Created by Administrator on 2018/09/13.
 */
public class ReflectionHelper {
    public static String getAttrNameFromMethod(String methodName) {
        if (methodName.length() < 4) {
            return null;
        }

        return Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4);
    }
}
