package com.example.blogapi.utils;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @ClassName QiniuUtilTest
 * @Description
 * @Author 15014
 * @Time 2022/10/20 13:58
 * @Version 1.0
 */
@SpringBootTest
@Ignore
class QiniuUtilTest {
    @Autowired
    QiniuUtil qiniuUtil;

    @Test
    void upload() throws URISyntaxException, IOException, InterruptedException {
        File file = new File("C:\\Users\\15014\\Pictures\\Camera Roll\\WIN_20220417_16_36_12_Pro.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        qiniuUtil.upload(inputStream, "aaa", "png");
    }
}