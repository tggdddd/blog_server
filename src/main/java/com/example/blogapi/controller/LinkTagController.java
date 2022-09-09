package com.example.blogapi.controller;

import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.LinktagService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/linkTag")
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
    /**获取文章的所有标签
     */
    @GetMapping("/getClass")
    public RespModel getArticleClass(@RequestParam(name = "id") int articleId){
        return linktagService.getArticleClass(articleId);
    }

    /**根据标签id获取文章*/
    @GetMapping("/search")
    public RespModel search(@RequestParam String tagName){
        return linktagService.searchArticle(tagName);
    }

    /**根据标签id获取文章的总数*/
    @GetMapping("/searchTotal")
    public RespModel searchTotal(@RequestParam String tagName){
        return linktagService.searchArticleTotal(tagName);
    }

}
