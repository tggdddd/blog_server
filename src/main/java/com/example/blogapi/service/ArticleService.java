package com.example.blogapi.service;

import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.resp.RespModel;

import java.util.List;

public interface ArticleService {

    /**
     * 添加文章
     * @param article
     * @return
     */
    RespModel addArticle(ArticleEntity article);
    /**
     * 通过文章标题模糊查询
     * @param title
     * @return
     */
    RespModel findByTitle(String title);

    /**
     * 查询所有文章
     *
     */
    RespModel findAll();

    /**
     * 通过文章ID修改文章
     */
    RespModel updateArticle(ArticleEntity article);
}

