package com.example.blogapi.controller;


import com.example.blogapi.pojo.CommentEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.CommentService;
import com.example.blogapi.service.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private MailService mailService;

    /**
     * 新增评论
     *
     * @param commentEntity
     * @return
     */
    @PostMapping("/add")
    public RespModel add(@RequestBody CommentEntity commentEntity, HttpServletRequest request) {
        commentEntity.setDate(new Date());
        RespModel respModel = commentService.addComment(commentEntity);
        if (respModel.getCode() == "200") {
            String url = request.getHeader("Referer");
            url += "article?id=" + commentEntity.getArticleId();
            String email = "15014586591@139.com";
            if (commentEntity.getParentId() != -1) {
                email = commentService.getEmail(commentEntity.getParentId());
            }
            mailService.sendSimpleMail(email, "收到一个回复——来自blog", "您在博客上的评论被回复了，点击" + url + "查看回复的内容");
        }
        return respModel;
    }

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
