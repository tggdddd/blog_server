package com.example.blogapi.service.impl;


import com.example.blogapi.mapper.TagMapper;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl  implements TagService {
    @Resource
    TagMapper tagMapper;
    @Override
    public RespModel addTag(TagEntity vo) {
        if(tagMapper.addTag(vo)!=0){
            return new RespModel(RespCode.SUCCESS,vo);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel findByLinkId(int id) {
        List<TagEntity> list = tagMapper.findByLinkId(id);
        if(list!=null){
            return new RespModel(RespCode.SUCCESS,list);
        }
        return new RespModel(RespCode.FAILURE,null);
    }
}