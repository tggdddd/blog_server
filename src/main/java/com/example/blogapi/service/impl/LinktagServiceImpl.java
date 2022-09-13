package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.LinktagMapper;
import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.LinktagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LinktagServiceImpl implements LinktagService {
    @Override
    public RespModel getArticleClass(int articleId) {
        List<TagEntity> list = linktagMapper.getArticleClass(articleId);
        if(list!=null){
            return new RespModel(RespCode.SUCCESS,list);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Resource
    LinktagMapper linktagMapper;
    @Override
    public RespModel addLinkTag(LinktagEntity linktagEntity) {
        if(linktagMapper.addLinkTag(linktagEntity)!=0){
            return new RespModel(RespCode.SUCCESS,linktagEntity);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel deleteLinkTag(LinktagEntity linktagEntity) {
        if(linktagMapper.deleteLinkTag(linktagEntity)!=0){
            return new RespModel(RespCode.SUCCESS,linktagEntity);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel searchArticle(String tagName) {
        List<ArticleEntity> list = linktagMapper.searchArticle(tagName);
        if(list != null){
            return new RespModel(RespCode.SUCCESS, list);
        }
        return new RespModel(RespCode.FAILURE, null);
    }

    @Override
    public RespModel searchArticleTotal(String tagName) {
        int res = linktagMapper.searchArticleTotal(tagName);
        return new RespModel(RespCode.SUCCESS, res);
    }

    @Override
    public int removeArticleTags(int articleId) {
        return linktagMapper.removeArticleTags(articleId);
    }
}