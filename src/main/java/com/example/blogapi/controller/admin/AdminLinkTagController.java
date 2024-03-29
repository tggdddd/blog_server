package com.example.blogapi.controller.admin;

import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.LinktagService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName LinkTagController
 * @Description
 * @Author 15014
 * @Time 2022/9/8 14:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/linkTag")
public class AdminLinkTagController {
    @Resource
    LinktagService linktagService;

    @PostMapping("/add")
    public RespModel add(@RequestBody LinktagEntity linktagEntity) {
        return linktagService.addLinkTag(linktagEntity);
    }

    @PostMapping("/delete")
    public RespModel delete(@RequestBody LinktagEntity linktagEntity) {
        return linktagService.deleteLinkTag(linktagEntity);
    }

    /**
     * 获取文章的所有标签
     */
    @GetMapping("/getClass")
    public RespModel getArticleClass(@RequestParam(name = "id") int articleId) {
        return linktagService.getArticleClass(articleId);
    }

    /**
     * 根据标签id获取文章
     */
    @GetMapping("/search")
    public RespModel search(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam String tagName) {
        PageHelper.startPage(pageNum, pageSize);
        RespModel respModel = linktagService.searchArticle(tagName);
        if (respModel.getCode() != "200") {
            return respModel;
        }
        // 获取标签
        List<ArticleEntity> list = (List<ArticleEntity>) respModel.getData();
        for (ArticleEntity articleEntity : list) {
            articleEntity.setTags((List<TagEntity>) linktagService.getArticleClass(articleEntity.getId()).getData());
        }
        return respModel;
    }

    /**
     * 根据标签id获取文章的总数
     */
    @GetMapping("/search/sum")
    public RespModel searchTotal(@RequestParam String tagName) {
        return linktagService.searchArticleTotal(tagName);
    }

}
