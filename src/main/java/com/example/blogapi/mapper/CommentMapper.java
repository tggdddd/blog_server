package com.example.blogapi.mapper;

import com.example.blogapi.pojo.CommentEntity;

import java.util.List;

public interface CommentMapper {
    /**
     * 新增评论
     */
    int addComment(CommentEntity commentEntity);


    /**
     * 通过评论的id删除评论
     *
     * @param id
     */
    int deleteCommentById(int id);

    /**
     * 通过文章的id查询第一层评论
     *
     * @param articleId
     */
    List<CommentEntity> findFirstCommentByArticleId(int articleId);

    /**
     * 通过文章的id查询评论
     *
     * @param articleId
     */
    List<CommentEntity> findCommentByArticleId(int articleId);

    /**
     * 通过文章的id查询评论的总数
     *
     * @param articleId
     */
    int findCommentByArticleIdTotal(int articleId);

    /**
     * 通过评论的id查询子评论
     *
     * @param commentId
     */
    List<CommentEntity> findCommentByCommentId(int commentId);

    /**
     * 获取所有评论
     */
    List<CommentEntity> pullComment();

    /**
     * 获取所有评论的总数
     */
    int pullCommentTotal();
    /**
     * 评论的子评论 保留
     */

    /**
     * 删除文章的评论 保留
     */
    /**
     * 通过评论ID获得邮箱
     */
    String getEmail(int id);
}
