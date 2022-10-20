package com.example.blogapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName ThreadPoolConfig
 * @Description
 * @Author 15014
 * @Time 2022/10/20 13:50
 * @Version 1.0
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig {
}
