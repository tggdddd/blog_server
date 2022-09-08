package com.example.blogapi.mapper;

import com.example.blogapi.pojo.LinktagEntity;

public interface LinktagMapper {
    /**
     * 增加文章ID和标签ID
     */
    int addLinkTag(LinktagEntity linktagEntity);

    /**
     * 删除文章的标签
     * （删除记录）
     */
    int deleteLinkTag(LinktagEntity linktagEntity);

}
