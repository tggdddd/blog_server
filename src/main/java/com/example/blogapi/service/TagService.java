package com.example.blogapi.service;

import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;

public interface TagService  {

    /**
     * 添加标签
     *
     * @param vo TagEntity
     */
    RespModel addTag(TagEntity tagEntity);

    /**
     * 通过文章id查找标签
     * @param id
     * @return
     */
    RespModel findByLinkId(int id);


    /**
     * 通过文章ID修改文章
     */
    RespModel updateTag(TagEntity tagEntity);

    /**
     * 获得所有标签
     */
    RespModel getAllTag();

    /**
     * 删除标签
     */
    RespModel removeTag(int id);
}

