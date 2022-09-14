package com.example.blogapi.service;

import com.example.blogapi.pojo.DraftEntity;
import com.example.blogapi.resp.RespModel;

/**
 * @ClassName DraftService
 * @Description
 * @Author 15014
 * @Time 2022/9/14 9:19
 * @Version 1.0
 */
public interface DraftService {

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    RespModel addArticle(DraftEntity article);

    /**
     * 查询所有文章
     */
    RespModel findAll();

    /**
     * 通过文章ID修改文章
     */
    RespModel updateArticle(DraftEntity article);

    /**
     * 获得文章的详情
     */
    RespModel getArticle(int id);

    /**
     * 删除文章
     */
    RespModel deleteArticle(int id);
}
