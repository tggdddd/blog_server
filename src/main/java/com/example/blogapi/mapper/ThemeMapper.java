package com.example.blogapi.mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ThemeMapper
 * @Description
 * @Author 15014
 * @Time 2022/9/15 16:33
 * @Version 1.0
 */
public interface ThemeMapper {
    /**
     * 获得所有主题
     */
    List<Map> getThemes();

    /**
     * 增加主题
     */
    Integer insertTheme(Map map);

    /**
     * 删除主题
     */
    Integer deleteTheme(Integer id);

    /**
     * 更新主题
     */
    Integer updateTheme(Map map);

    /**
     * 增加love次数1
     */
    Integer love(int id);
    // /**修改主题*/
    // Integer updateTheme(Map map);

    /**
     * 默认的主题ID
     */
    Integer defaultId();

    List<Map> getThemesContainerIgnore();
}