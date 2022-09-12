package com.example.blogapi.service;

import com.example.blogapi.pojo.CommentEntity;
import com.example.blogapi.resp.RespModel;

public interface CommentService{
    /**
     * 新增评论
     */
    RespModel addComment(CommentEntity commentEntity);


    /**
     * 通过评论的id删除评论
     *
     * @param id
     */
    RespModel deleteCommentById(int id);

    /**
     * 通过文章的id查询第一层评论
     *
     * @param articleId
     */
    RespModel findFirstCommentByArticleId(int articleId);

    /**
     * 通过文章的id查询评论
     *
     * @param articleId
     */
    RespModel findCommentByArticleId(int articleId);

    /**
     * 通过文章的id查询评论的总数
     *
     * @param articleId
     */
    RespModel findCommentByArticleIdTotal(int articleId);

    /**
     * 通过评论的id查询子评论
     *
     * @param commentId
     */
    RespModel findCommentByCommentId(int commentId);

    /**
     * 获取所有评论
     */
    RespModel pullComment();

    /**
     * 获取所有评论的总数
     */
    RespModel pullCommentTotal();
}

