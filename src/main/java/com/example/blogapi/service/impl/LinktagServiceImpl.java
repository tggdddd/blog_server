package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.LinktagMapper;
import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.LinktagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LinktagServiceImpl implements LinktagService {

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
}