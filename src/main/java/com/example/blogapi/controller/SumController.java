package com.example.blogapi.controller;

import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.SumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SumController
 * @Description
 * @Author 15014
 * @Time 2022/9/11 14:51
 * @Version 1.0
 */
@RestController
public class SumController {
    @Resource
    SumService service;

    @GetMapping({"/statistics", "/admin/statistics"})
    public RespModel statistics() {
        return service.getSum();
    }
}
