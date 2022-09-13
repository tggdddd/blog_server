package com.example.blogapi.service.impl;


import com.example.blogapi.mapper.TagMapper;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl  implements TagService {
    @Resource
    TagMapper tagMapper;
    @Override
    public RespModel addTag(TagEntity vo) {
        if(tagMapper.addTag(vo)!=0){
            return new RespModel(RespCode.SUCCESS,vo);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel getAllTag() {
        List<TagEntity> list = tagMapper.getAllTag();
        if (list != null) {
            return new RespModel(RespCode.SUCCESS, list);
        }
        return new RespModel(RespCode.FAILURE, null);
    }

    @Override
    public RespModel removeTag(int id) {
        int res = tagMapper.deleteTag(id);
        if (res != 0) {
            return new RespModel(RespCode.SUCCESS, res);
        } else {
            RespModel respModel = new RespModel(RespCode.FAILURE, res);
            respModel.setMsg("存在文章使用此标签");
            return respModel;
        }
    }

    @Override
    public RespModel findByLinkId(int id) {
        List<TagEntity> list = tagMapper.findByLinkId(id);
        if (list != null) {
            return new RespModel(RespCode.SUCCESS, list);
        }
        return new RespModel(RespCode.FAILURE, null);
    }

    @Override
    public RespModel updateTag(TagEntity tagEntity) {
        int res = tagMapper.updateTag(tagEntity);
        if(res!=0){
            return new RespModel(RespCode.SUCCESS,res);
        }
        RespModel respModel = new RespModel(RespCode.FAILURE,res);
        respModel.setMsg("修改失败");
        return respModel;
    }
}