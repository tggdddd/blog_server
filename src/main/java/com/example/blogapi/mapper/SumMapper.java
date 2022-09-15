package com.example.blogapi.mapper;

import com.example.blogapi.pojo.SumEntity;

/**
 * @ClassName SumMapper
 * @Description
 * @Author 15014
 * @Time 2022/9/11 14:52
 * @Version 1.0
 */
public interface SumMapper {
    /**
     * 获得网站总的信息
     */
    SumEntity getSum();

    Integer getCommentTotal();
}
