package com.example.blogapi.mapper;

import com.example.blogapi.pojo.GradeEntity;
import com.example.blogapi.pojo.TagEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    /**
     * 增加文章的评分
     * @param articleId
     * @return
     */
    int addGrade(int articleId);

    /**
     * 查询评分
     * @param articleId
     * @return GradeEntity
     */
    GradeEntity getGrade(int articleId);

    /**
     * 修改评分-->增加评分
     */
    int updateGrade(int articleId,int point);

    /**删除评分*/
    int deleteGrade(int articleId);

}
