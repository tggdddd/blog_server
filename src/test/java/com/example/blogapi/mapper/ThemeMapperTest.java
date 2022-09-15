package com.example.blogapi.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

/**
 * @ClassName ThemeMapperTest
 * @Description
 * @Author 15014
 * @Time 2022/9/15 15:52
 * @Version 1.0
 */
@SpringBootTest
@ComponentScan("com.example.blogapi.mapper.ThemeMapper")
class ThemeMapperTest {

    @Resource
    ThemeMapper themeMapper;

    @Test
    void getThemes() {

    }
}