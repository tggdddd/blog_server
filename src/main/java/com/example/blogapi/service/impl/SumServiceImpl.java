package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.SumMapper;
import com.example.blogapi.pojo.SumEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.SumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName SumServiceImpl
 * @Description
 * @Author 15014
 * @Time 2022/9/11 15:00
 * @Version 1.0
 */
@Service

public class SumServiceImpl implements SumService {
    @Resource
    SumMapper sumMapper;

    @Override
    public RespModel getSum() {
        SumEntity res = sumMapper.getSum();
        Integer com = sumMapper.getCommentTotal();
        res.setCommentTotal(com == null ? 0 : com);
        res.setArticleTotal(res.getArticleTotal() == null ? 0 : res.getArticleTotal());
        res.setVisitTotal(res.getVisitTotal() == null ? 0 : res.getVisitTotal());
        return new RespModel(RespCode.SUCCESS, res);
    }
}
