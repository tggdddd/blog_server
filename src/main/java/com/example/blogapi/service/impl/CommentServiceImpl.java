package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.CommentMapper;
import com.example.blogapi.pojo.CommentEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;

    @Override
    public RespModel addComment(CommentEntity commentEntity) {
        if(commentMapper.addComment(commentEntity)!=0){
            return new RespModel(RespCode.SUCCESS,commentEntity);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel deleteCommentById(int articleId) {
        if(commentMapper.deleteCommentById(articleId)!=0){
            return new RespModel(RespCode.SUCCESS,articleId);
        }
        return new RespModel(RespCode.FAILURE,null);
    }
    /////////////////////////多层的json/////////////////////////////////////////////////////
    // @Override
    // public RespModel findCommentByArticleId(int articleId) {
    //     List<CommentEntity> list = commentMapper.findCommentByArticleId(articleId);
    //     if(list!=null){
    //         //获取子评论
    //         getSubComment(list);
    //         return new RespModel(RespCode.SUCCESS,list);
    //     }
    //     return new RespModel(RespCode.FAILURE,null);
    // }
    // /**评论子查询*/
    // public void getSubComment(List<CommentEntity> list){
    //     if(list == null){
    //         return;
    //     }
    //     for (CommentEntity commentEntity : list) {
    //         System.out.println(commentEntity.getId());
    //         Object subList = findCommentByCommentId(commentEntity.getId()).getData();
    //         commentEntity.setChildren((List<CommentEntity>) subList);
    //         getSubComment(commentEntity.getChildren());
    //     }
    // }
    ///////////////////////////////////////////////////////////////////////////////////////
    @Override
    public RespModel findCommentByCommentId(int commentId) {
        List<CommentEntity> list = commentMapper.findCommentByCommentId(commentId);
        if (list != null) {
            return new RespModel(RespCode.SUCCESS, list);
        }
        return new RespModel(RespCode.FAILURE, null);
    }

    @Override
    public RespModel findFirstCommentByArticleId(int articleId) {
        List<CommentEntity> list = commentMapper.findFirstCommentByArticleId(articleId);
        if (list != null) {
            // 获取子评论
            for (CommentEntity commentEntity : list) {
                getSubComment(commentEntity, commentEntity);
            }
            return new RespModel(RespCode.SUCCESS, list);
        }
        return new RespModel(RespCode.FAILURE, null);
    }

    @Override
    public RespModel findCommentByArticleId(int articleId) {
        List<CommentEntity> list = commentMapper.findCommentByArticleId(articleId);
        return new RespModel(RespCode.SUCCESS, list);
    }

    @Override
    public RespModel findCommentByArticleIdTotal(int articleId) {
        Integer res = commentMapper.findCommentByArticleIdTotal(articleId);
        return new RespModel(RespCode.SUCCESS, res);
    }

    @Override
    public RespModel pullComment() {
        List<CommentEntity> list = commentMapper.pullComment();
        if (list != null) {
            return new RespModel(RespCode.SUCCESS, list);
        }
        return new RespModel(RespCode.FAILURE, null);
    }

    @Override
    public String getEmail(int id) {
        return commentMapper.getEmail(id);
    }

    @Override
    public RespModel pullCommentTotal() {
        Integer res = commentMapper.pullCommentTotal();
        return new RespModel(RespCode.SUCCESS, res);
    }

    public void getSubComment(CommentEntity target, CommentEntity parent) {
        // 获取children对象
        List<CommentEntity> list = parent.getChildren();
        if (list == null) {
            list = new ArrayList<>();
            parent.setChildren(list);
        }
        // 获取子评论
        List<CommentEntity> subList = (List<CommentEntity>) findCommentByCommentId(target.getId()).getData();
        //遍历添加子评论
        for (CommentEntity commentEntity : subList) {
            list.add(commentEntity);
            getSubComment(commentEntity,parent);
        }
    }
}