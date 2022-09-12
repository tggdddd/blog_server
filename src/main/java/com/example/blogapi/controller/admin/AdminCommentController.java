package com.example.blogapi.controller.admin;


import com.example.blogapi.mapper.ArticleMapper;
import com.example.blogapi.pojo.CommentEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.CommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private ArticleMapper articleMapper;

    /**
     * 新增评论
     *
     * @param commentEntity
     * @return
     */
    @PostMapping("/add")
    public RespModel add(CommentEntity commentEntity) {
        commentEntity.setDate(new Date());
        return commentService.addComment(commentEntity);
    }

    /**
     * 拉取评论
     *
     * @param articleId 若不为null 则根据文章id获取评论
     * @return
     */
    @GetMapping("/pull")
    public RespModel findByLinkId(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(required = false) Integer articleId) {
        PageHelper.startPage(pageNum, pageSize);
        // 则根据文章id获取评论
        RespModel respModel = null;
        if (articleId != null) {
            respModel = commentService.findCommentByArticleId(articleId);
            // 获取所有评论
        } else {
            respModel = commentService.pullComment();
        }
        // 获取评论的标题
        HashMap<Integer, String> hashMap = new HashMap();
        List<CommentEntity> list = (List<CommentEntity>) respModel.getData();
        for (CommentEntity commentEntity : list) {
            int id = commentEntity.getArticleId();
            if (hashMap.get(id) != null) {
                commentEntity.setTitle(hashMap.get(id));
            } else {
                String title = articleMapper.getTitle(id);
                hashMap.put(id, title);
                commentEntity.setTitle(title);
            }
        }
        return respModel;
    }

    /**
     * 拉取评论总数
     */
    @GetMapping("/pullTotal")
    public RespModel findByLinkIdTotal(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(required = false) Integer articleId) {
        PageHelper.startPage(pageNum, pageSize);
        // 则根据文章id获取评论
        RespModel respModel = null;
        if (articleId != null) {
            respModel = commentService.findCommentByArticleIdTotal(articleId);
            // 获取所有评论
        } else {
            respModel = commentService.pullCommentTotal();
        }
        return respModel;
    }

    /**
     * 删除评论
     */
    @PostMapping("/delete")
    public RespModel updateTag(@RequestParam("id") int commentId) {
        return commentService.deleteCommentById(commentId);
    }

}
