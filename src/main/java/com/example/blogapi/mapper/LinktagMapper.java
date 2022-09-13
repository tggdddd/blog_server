package com.example.blogapi.mapper;

import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.pojo.TagEntity;

import java.util.List;

public interface LinktagMapper {
    /**
     * 增加文章ID和标签ID
     */
    int addLinkTag(LinktagEntity linktagEntity);

    /**
     * 删除文章的标签
     * （删除记录）
     */
    int deleteLinkTag(LinktagEntity linktagEntity);

    /**
     * 根据标签名字获取文章
     */
    List<ArticleEntity> searchArticle(String tagName);

    /**
     * 根据标签名字获取文章的总数
     */
    int searchArticleTotal(String tagName);

    /**
     * 获取文章所有标签
     */
    List<TagEntity> getArticleClass(int articleId);

    /*删除文章的所有标签*/
    int removeArticleTags(int articleId);
}
