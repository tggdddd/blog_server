package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.ArticleMapper;
import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
@Resource
private ArticleMapper articleMapper;

    @Override
    public RespModel addArticle(ArticleEntity article) {
        int res = articleMapper.addArticle(article);
        if(res!=0){
            return new RespModel(RespCode.SUCCESS,res);
        }
        return new RespModel(RespCode.FAILURE,res);
    }

    @Override
    public RespModel findByTitle(String title) {
        List<ArticleEntity> res = articleMapper.findByTitle(title);
        if(res!=null){
            return new RespModel(RespCode.SUCCESS,res);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel findAll() {
        List<ArticleEntity> res = articleMapper.findAll();
        if(res!=null){
            return new RespModel(RespCode.SUCCESS,res);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel updateArticle(ArticleEntity article) {
        int res = articleMapper.updateArticle(article);
        if(res!=0){
            return new RespModel(RespCode.SUCCESS,res);
        }
        RespModel respModel = new RespModel(RespCode.FAILURE,res);
        respModel.setMsg("修改失败");
        return respModel;
    }
}