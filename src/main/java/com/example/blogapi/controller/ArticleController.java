package com.example.blogapi.controller;

import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.ArticleService;
import com.example.blogapi.service.TagService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ArticleController
 * @Description
 * @Author 15014
 * @Time 2022/9/8 12:16
 * @Version 1.0
 */
@RequestMapping("/article")
@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @PostMapping("/add")
    public RespModel addArticle(@RequestBody ArticleEntity article){
        return articleService.addArticle(article);
    }

    /**
     * 通过文章标题模糊查询
     * @param title
     * @return
     */
    @GetMapping("/search/{title}")
    public RespModel findByTitle(@PathVariable String title){
        return articleService.findByTitle(title);
    }

    /**
     * 查询所有文章
     *
     */
    @GetMapping("/pull")
    public RespModel findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer limit){
        PageHelper.startPage(pageNum,limit);
        return articleService.findAll();
    }

    /**
     * 通过文章ID修改文章
     */
    @PostMapping("/update")
    public RespModel updateArticle(@RequestBody ArticleEntity article){
        return articleService.updateArticle(article);
    }

}
