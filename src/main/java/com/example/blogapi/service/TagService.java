package com.example.blogapi.service;

import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;

import java.util.List;

public interface TagService  {

    /**
     * 添加标签
     *
     * @param vo TagEntity
     */
    RespModel addTag(TagEntity tagEntity);

    RespModel findByLinkId(int id);
}

