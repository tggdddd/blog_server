package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.DraftMapper;
import com.example.blogapi.pojo.DraftEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.DraftService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DraftServiceImpl
 * @Description
 * @Author 15014
 * @Time 2022/9/14 9:20
 * @Version 1.0
 */
@Service
public class DraftServiceImpl implements DraftService {

    @Resource
    private DraftMapper draftMapper;

    @Override
    public RespModel deleteArticle(int id) {
        int res = draftMapper.deleteArticle(id);
        if (res != 0) {
            return new RespModel(RespCode.SUCCESS, res);
        }
        return new RespModel(RespCode.FAILURE, res);
    }

    /**
     * 获得文章
     *
     * @param id
     * @return
     */
    @Override
    public RespModel getArticle(int id) {
        DraftEntity res = draftMapper.getArticle(id);
        if (res != null) {
            return new RespModel(RespCode.SUCCESS, res);
        }
        return new RespModel(RespCode.FAILURE, res);
    }

    @Override
    public RespModel addArticle(DraftEntity article) {
        int res = draftMapper.addArticle(article);
        if (res != 0) {
            return new RespModel(RespCode.SUCCESS, res);
        }
        return new RespModel(RespCode.FAILURE, res);
    }

    @Override
    public RespModel findAll() {
        List<DraftEntity> res = draftMapper.findAll();
        if (res != null) {
            return new RespModel(RespCode.SUCCESS, res);
        }
        return new RespModel(RespCode.FAILURE, null);
    }

    @Override
    public RespModel updateArticle(DraftEntity article) {
        int res = draftMapper.updateArticle(article);
        if (res != 0) {
            return new RespModel(RespCode.SUCCESS, res);
        }
        RespModel respModel = new RespModel(RespCode.FAILURE, res);
        respModel.setMsg("修改失败");
        return respModel;
    }
}
