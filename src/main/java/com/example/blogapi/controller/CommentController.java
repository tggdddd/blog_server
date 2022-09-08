package com.example.blogapi.controller;


import com.example.blogapi.mapper.CommentMapper;
import com.example.blogapi.pojo.CommentEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.CommentService;
import com.example.blogapi.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    /**
     * 新增评论
     * @param commentEntity
     * @return
     */
    @PostMapping("/add")
    public RespModel add(@RequestBody CommentEntity commentEntity){
        return commentService.addComment(commentEntity);
    }

    /**
     * 拉取评论
     * @param articleId
     * @return
     */
    @GetMapping("/pull")
    public RespModel findByLinkId(int articleId){
        return commentService.findCommentByArticleId(articleId);
    }

    /**
     * 删除评论
     */
    @PostMapping("/delete")
    public RespModel updateTag(int commentId){
        return commentService.deleteCommentById(commentId);
    }

}
