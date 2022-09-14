package com.example.blogapi.controller.admin;

import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.pojo.GradeEntity;
import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.pojo.TagsId;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.ArticleService;
import com.example.blogapi.service.GradeService;
import com.example.blogapi.service.LinktagService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *
 */
@RequestMapping("/admin/article")
@RestController
public class AdminArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private LinktagService linktagService;
    @Resource
    private GradeService gradeService;

    /**
     * 添加文章
     *
     * @param article 包括 title author content
     */
    @PostMapping("/add")
    public RespModel addArticle(ArticleEntity article, TagsId tagsId) {
        article.setDate(new Date());
        RespModel respModel = articleService.addArticle(article);
        // 返回插入的id
        int id = article.getId();
        if (id == 0) {
            return respModel;
        }
        // 添加文章的关联标签
        for (Integer tagId : tagsId.getTagsId()) {
            linktagService.addLinkTag(new LinktagEntity(-1, id, tagId));
        }
        // 添加对映的评分表
        gradeService.addGrade(id);
        return respModel;
    }

    /**
     * 删除文章
     *
     * @param id 文章id
     */
    @PostMapping("/delete")
    public RespModel deleteArticle(Integer id) {
        return articleService.deleteArticle(id);
    }

    /**
     * 通过文章标题模糊查询
     */
    @GetMapping("/search")
    public RespModel findByTitle(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, String title) {
        PageHelper.startPage(pageNum, pageSize);
        RespModel respModel = articleService.findByTitle(title);
        if (respModel.getCode() != "200") {
            return respModel;
        }
        // 逐个处理每篇文章
        List<ArticleEntity> list = (List<ArticleEntity>) respModel.getData();
        for (ArticleEntity articleEntity : list) {
            // 获取标签
            articleEntity.setTags((List<TagEntity>) linktagService.getArticleClass(articleEntity.getId()).getData());
            // 获取评分
            articleEntity.setGrade((GradeEntity) gradeService.getGrade(articleEntity.getId()).getData());
        }
        return respModel;
    }

    /**
     * 通过文章标题模糊查询的总数
     */
    @GetMapping("/search/sum")
    public RespModel findByTitleTotal(String title) {
        return articleService.findByTitleTotal(title);
    }

    /**
     * 获得文章的详细内容
     */
    @GetMapping("/detail")
    public RespModel getArticle(@RequestParam int id) {
        RespModel respModel = articleService.getArticle(id);
        if (respModel.getCode() != "200") {
            return respModel;
        }
        ArticleEntity articleEntity = (ArticleEntity) respModel.getData();
        // 获取标签
        articleEntity.setTags((List<TagEntity>) linktagService.getArticleClass(articleEntity.getId()).getData());
        return respModel;
    }

    /**
     * 查询所有文章
     */
    @GetMapping("/pull")
    public RespModel findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "0") String tagName) {
        PageHelper.startPage(pageNum, pageSize);
        RespModel respModel = articleService.findAll();
        if (respModel.getCode() != "200") {
            return respModel;
        }
        // 逐个处理每篇文章
        List<ArticleEntity> list = (List<ArticleEntity>) respModel.getData();
        for (ArticleEntity articleEntity : list) {
            // 获取标签
            articleEntity.setTags((List<TagEntity>) linktagService.getArticleClass(articleEntity.getId()).getData());
            // 获取评分
            articleEntity.setGrade((GradeEntity) gradeService.getGrade(articleEntity.getId()).getData());
        }
        return respModel;
    }

    /**
     * 查询所有文章的总数
     */
    @GetMapping("/pull/sum")
    public RespModel findAllTotal() {
        return articleService.findAllTotal();
    }

    /**
     * 查询浏览人数排名前十的文章
     */
    @GetMapping("/getHotTopics")
    public RespModel searchHots() {
        return articleService.getHots();
    }

    /**
     * 通过文章ID修改文章
     */
    @PostMapping("/update")
    public RespModel updateArticle(ArticleEntity article, TagsId tagsId) {
        RespModel respModel = articleService.updateArticle(article);
        int id = article.getId();
        if (id == 0) {
            return respModel;
        }
        // 修改文章的关联标签
        // 先删除再增加
        linktagService.removeArticleTags(id);
        for (Integer tagId : tagsId.getTagsId()) {
            linktagService.addLinkTag(new LinktagEntity(-1, id, tagId));
        }
        return respModel;
    }

}
