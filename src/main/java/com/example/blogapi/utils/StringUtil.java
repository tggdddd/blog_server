package com.example.blogapi.utils;

import java.util.UUID;

/**
 * @ClassName StringUtil
 * @Description
 * @Author 15014
 * @Time 2022/10/20 15:30
 * @Version 1.0
 */
public class StringUtil {
    // 生成UUID字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static boolean isEmpty(String string) {
        if (string == null || string.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
