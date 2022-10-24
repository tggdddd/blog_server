package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.ThemeMapper;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.ThemeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ThemeServiceImpl
 * @Description
 * @Author 15014
 * @Time 2022/9/15 16:10
 * @Version 1.0
 */
@Service
public class ThemeServiceImpl implements ThemeService {
    @Resource
    ThemeMapper themeMapper;

    @Override
    public RespModel getThemes() {
        List<Map> list = themeMapper.getThemes();
        return new RespModel(RespCode.SUCCESS, list);
    }

    @Override
    public RespModel getThemesContainerIgnore() {
        List<Map> list = themeMapper.getThemesContainerIgnore();
        return new RespModel(RespCode.SUCCESS, list);
    }

    @Override
    public RespModel addThemes(Map map) {
        int i = themeMapper.insertTheme(map);
        if (i == 1) {
            return new RespModel(RespCode.SUCCESS, i);
        } else {
            return new RespModel(RespCode.FAILURE, i);
        }

    }

    @Override
    public RespModel love(int id) {
        return new RespModel(RespCode.SUCCESS, themeMapper.love(id));
    }

    @Override
    public RespModel deleteTheme(int id) {
        int res = themeMapper.deleteTheme(id);
        if (res == 1) {
            return new RespModel(RespCode.SUCCESS, res);
        }
        return new RespModel(RespCode.FAILURE, res);
    }

    @Override
    public RespModel update(Map map) {
        int res = themeMapper.updateTheme(map);
        if (res == 1) {
            return new RespModel(RespCode.SUCCESS, res);
        }
        return new RespModel(RespCode.FAILURE, res);
    }

    @Override
    public RespModel defaultId() {
        return new RespModel(RespCode.SUCCESS, themeMapper.defaultId());
    }
}
