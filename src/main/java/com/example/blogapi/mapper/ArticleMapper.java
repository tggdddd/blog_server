package com.example.blogapi.mapper;

import com.example.blogapi.pojo.ArticleEntity;

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
     * 查询模糊查询的结果总数
     *
     */
    int findByTitleTotal(String title);
    /**
     * 查询所有文章
     *
     */
    List<ArticleEntity> findAll();

    /**
     * 查询所有文章的总数
     *
     */
    int findAllTotal();

    String getTitle(int id);

    /**
     * 通过文章ID修改文章
     */
    int updateArticle(ArticleEntity article);

    /**
     * 查询热点文章
     *
     */
    List<ArticleEntity> getHots();

    /**通过id获得文章
     * */
    ArticleEntity getArticle(int id);

    /**增加浏览的次数*/
    void increase(int id);
}
