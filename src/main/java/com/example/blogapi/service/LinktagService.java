package com.example.blogapi.service;

import com.example.blogapi.pojo.LinktagEntity;
import com.example.blogapi.resp.RespModel;

public interface LinktagService{

    /**
     * 增加文章ID和标签ID
     */
    RespModel addLinkTag(LinktagEntity linktagEntity);

    /**
     * 删除文章的标签
     * （删除记录）
     */
    RespModel deleteLinkTag(LinktagEntity linktagEntity);
}

