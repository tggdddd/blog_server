package com.example.blogapi.service;

import com.example.blogapi.resp.RespModel;

import java.util.Map;

/**
 * @ClassName ThemeService
 * @Description
 * @Author 15014
 * @Time 2022/9/15 16:09
 * @Version 1.0
 */
public interface ThemeService {
    /**
     * 获得所有主题
     */
    public RespModel getThemes();

    /**
     * 新增主题
     */
    public RespModel addThemes(Map map);

    /**
     * 增加love次数1
     */
    public RespModel love(int id);

    /**
     * 删除
     */
    public RespModel deleteTheme(int id);

    /**
     * 修改
     */
    public RespModel update(Map map);
}

