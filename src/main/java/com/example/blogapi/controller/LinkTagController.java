package com.example.blogapi.controller;

import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.LinktagService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName LinkTagController
 * @Description
 * @Author 15014
 * @Time 2022/9/8 14:33
 * @Version 1.0
 */
@RestController
public class LinkTagController {
    @Resource
    LinktagService linktagService;

    @PostMapping("/add")
    public RespModel add(@RequestBody LinktagEntity linktagEntity){
        return linktagService.addLinkTag(linktagEntity);
    }
    @PostMapping("/delete")
    public RespModel delete(@RequestBody LinktagEntity linktagEntity){
        return linktagService.deleteLinkTag(linktagEntity);
    }
}
