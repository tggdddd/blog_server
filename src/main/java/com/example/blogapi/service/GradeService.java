package com.example.blogapi.service;

import com.example.blogapi.pojo.GradeEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;

public interface GradeService {
    /**
     * 增加文章的评分
     * @param articleId
     * @return
     */
    RespModel addGrade(int articleId);

    /**
     * 查询评分
     * @param articleId
     * @return GradeEntity
     */
    RespModel getGrade(int articleId);

    /**
     * 修改评分-->增加评分
     */
    RespModel updateGrade(int articleId,int point);

    /**删除评分*/
    RespModel deleteGrade(int articleId);

}

