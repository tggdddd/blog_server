package com.example.blogapi.mapper;

import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.pojo.TagEntity;

import java.util.List;

public interface ArticleMapper {
    /**
     * 添加文章
     * @param article
     * @return
     */
    int addArticle(ArticleEntity article);

    /**
     * 通过文章标题模糊查询
     * @param title
     * @return
     */
    List<ArticleEntity> findByTitle(String title);

    /**
     * 查询所有文章
     *
     */
    List<ArticleEntity> findAll();

    /**
     * 通过文章ID修改文章
     */
    int updateArticle(ArticleEntity article);
}
