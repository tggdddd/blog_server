package com.example.blogapi.controller.admin;

import com.example.blogapi.pojo.DraftEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.DraftService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName AdminDraftController
 * @Description
 * @Author 15014
 * @Time 2022/9/14 9:27
 * @Version 1.0
 */
@RequestMapping("/admin/draft")
@RestController
public class AdminDraftController {
    @Resource
    private DraftService draftService;

    /**
     * 添加草稿
     *
     * @param article 包括 title author content
     */
    @PostMapping("/add")
    public RespModel addArticle(DraftEntity article) {
        article.setDate(new Date());
        RespModel respModel = draftService.addArticle(article);
        return respModel;
    }

    /**
     * 删除草稿
     *
     * @param id 草稿id
     */
    @PostMapping("/delete")
    public RespModel deleteArticle(Integer id) {
        return draftService.deleteArticle(id);
    }

    /**
     * 获得草稿的详细内容
     */
    @GetMapping("/detail")
    public RespModel getArticle(@RequestParam int id) {
        RespModel respModel = draftService.getArticle(id);
        return respModel;
    }

    /**
     * 查询所有文章
     */
    @GetMapping("/pull")
    public RespModel findAll() {
        RespModel respModel = draftService.findAll();
        return respModel;
    }

    /**
     * 通过文章ID修改文章
     */
    @PostMapping("/update")
    public RespModel updateArticle(DraftEntity article) {
        article.setDate(new Date());
        RespModel respModel = draftService.updateArticle(article);
        return respModel;
    }

}
