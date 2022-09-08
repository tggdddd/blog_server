package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.CommentMapper;
import com.example.blogapi.mapper.LinktagMapper;
import com.example.blogapi.pojo.CommentEntity;
import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public RespModel findCommentByArticleId(int articleId) {
        List<CommentEntity> list = commentMapper.findCommentByArticleId(articleId);
        if(list!=null){
            //获取子评论
            for (CommentEntity commentEntity : list) {
                Object subList = findCommentByCommentId(commentEntity.getId()).getData();
                if(subList!=null){
                    commentEntity.setSubComment((List<CommentEntity>) subList);
                }
            }
            return new RespModel(RespCode.SUCCESS,list);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel findCommentByCommentId(int commentId) {
        List<CommentEntity> list = commentMapper.findCommentByArticleId(commentId);
        if(list!=null){
            return new RespModel(RespCode.SUCCESS,list);
        }
        return new RespModel(RespCode.FAILURE,null);
    }
}