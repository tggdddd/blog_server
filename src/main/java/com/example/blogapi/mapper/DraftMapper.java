package com.example.blogapi.mapper;

import com.example.blogapi.pojo.DraftEntity;

import java.util.List;

/**
 * @ClassName DraftMapper
 * @Description
 * @Author 15014
 * @Time 2022/9/14 9:16
 * @Version 1.0
 */
public interface DraftMapper {
    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    int addArticle(DraftEntity article);

    /**
     * 查询所有文章
     */
    List<DraftEntity> findAll();


    /**
     * 通过文章ID修改文章
     */
    int updateArticle(DraftEntity article);

    /**
     * 通过id获得文章
     */
    DraftEntity getArticle(int id);

    /**
     * 删除文章
     */
    int deleteArticle(int id);
}
