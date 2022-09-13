package com.example.blogapi.service;

import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.resp.RespModel;

public interface LinktagService{

    /**
     * 增加文章ID和标签ID
     */
    RespModel addLinkTag(LinktagEntity linktagEntity);

    /**
     * 删除文章的标签
     * （删除记录）
     */
    RespModel deleteLinkTag(LinktagEntity linktagEntity);

    /**
     * 根据标签名字获取文章
     */
    RespModel searchArticle(String tagName);

    /**
     * 根据标签id获取文章的总数
     */
    RespModel searchArticleTotal(String tagName);

    /**
     * 获取文章的所有标签
     */
    RespModel getArticleClass(int articleId);

    /**
     * 删除文章的所有标签
     */
    int removeArticleTags(int articleId);
}

