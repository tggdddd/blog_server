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
    public RespModel addThemes(Map map) {
        return new RespModel(RespCode.SUCCESS, themeMapper.insertTheme(map));
    }

    @Override
    public RespModel love(int id) {
        return new RespModel(RespCode.SUCCESS, themeMapper.love(id));
    }
}
