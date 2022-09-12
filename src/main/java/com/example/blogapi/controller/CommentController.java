package com.example.blogapi.controller;


import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    // /**
    //  * 新增评论
    //  * @param commentEntity
    //  * @return
    //  */
    // @PostMapping("/add")
    // public RespModel add(@RequestBody CommentEntity commentEntity){
    //     commentEntity.setDate(new Date());
    //     return commentService.addComment(commentEntity);
    // }

    /**
     * 拉取评论
     *
     * @param articleId 文章ID
     */
    @GetMapping("/pull")
    public RespModel findByLinkId(@RequestParam(name = "id") int articleId) {
        return commentService.findFirstCommentByArticleId(articleId);
    }

    // /**
    //  * 删除评论
    //  */
    // @PostMapping("/delete")
    // public RespModel updateTag(int commentId){
    //     return commentService.deleteCommentById(commentId);
    // }

}
