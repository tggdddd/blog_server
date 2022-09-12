package com.example.blogapi.controller;

import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.ArticleService;
import com.example.blogapi.service.LinktagService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@RequestMapping("/article")
@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private LinktagService linktagService;
    // /**
    //  * 添加文章
    //  */
    // @PostMapping("/add")
    // public RespModel addArticle(@RequestBody ArticleEntity article){
    //     article.setDate(new Date());
    //     return articleService.addArticle(article);
    // }

    /**
     * 通过文章标题模糊查询
     */
    @GetMapping("/search/{title}")
    public RespModel findByTitle(@PathVariable String title) {
        return articleService.findByTitle(title);
    }

    /**
     * 通过文章标题模糊查询的总数
     */
    @GetMapping("/search/{title}/sum")
    public RespModel findByTitleTotal(@PathVariable String title){
        return articleService.findByTitleTotal(title);
    }
    /**获得文章的详细内容*/
    @GetMapping("/detail")
    public RespModel getArticle(@RequestParam int id){
        //增加浏览次数
        articleService.increase(id);
        return articleService.getArticle(id);
    }

    /**
     * 查询所有文章
     * @param tagName 弃用
     */
    @GetMapping("/pull")
    public RespModel findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "0") String tagName){
        PageHelper.startPage(pageNum,pageSize);
        RespModel respModel = articleService.findAll();
        if (!respModel.getCode().equals("200")) {
            return respModel;
        }
        //获取标签
        List<ArticleEntity> list = (List<ArticleEntity>)respModel.getData();
        for (ArticleEntity articleEntity : list) {
            articleEntity.setTags((List<TagEntity>) linktagService.getArticleClass(articleEntity.getId()).getData());
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
    // /**
    //  * 通过文章ID修改文章
    //  */
    // @PostMapping("/update")
    // public RespModel updateArticle(@RequestBody ArticleEntity article){
    //     return articleService.updateArticle(article);
    // }

}
