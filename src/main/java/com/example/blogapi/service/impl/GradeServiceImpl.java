package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.GradeMapper;
import com.example.blogapi.pojo.GradeEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName GradeServiceImpl
 * @Description
 * @Author 15014
 * @Time 2022/9/9 19:11
 * @Version 1.0
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    GradeMapper gradeMapper;
    @Override
    public RespModel addGrade(int articleId) {
        if(gradeMapper.addGrade(articleId)!=0){
            return new RespModel(RespCode.SUCCESS,1);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel getGrade(int articleId) {
        GradeEntity gradeEntity = gradeMapper.getGrade(articleId);
        if(gradeEntity!=null){
            return new RespModel(RespCode.SUCCESS,gradeEntity);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel updateGrade(int articleId, int point) {
        if(gradeMapper.updateGrade(articleId,point)!=0){
            return new RespModel(RespCode.SUCCESS,1);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel deleteGrade(int articleId) {
        if(gradeMapper.deleteGrade(articleId)!=0){
            return new RespModel(RespCode.SUCCESS,1);
        }
        return new RespModel(RespCode.FAILURE,null);
    }
}
