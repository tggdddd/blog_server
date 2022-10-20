package com.example.blogapi.controller.admin;

import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.ThemeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ThemeController
 * @Description
 * @Author 15014
 * @Time 2022/9/15 16:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/theme")
public class AdminThemeController {
    @Resource
    ThemeService themeService;

    /**
     * 返回所有的主题
     */
    @GetMapping("/all")
    public RespModel getThemes() {
        return themeService.getThemes();
    }

    @PostMapping("/add")
    public RespModel addTheme(Map<String, String> map) {
        return themeService.addThemes(map);
    }

    @PostMapping("/update")
    public RespModel updateTheme(Map<String, String> map, HttpServletRequest request) {
        Map<String, String[]> MAPs = request.getParameterMap();
        Map<String, String> maps = new HashMap<>();
        for (Map.Entry<String, String[]> stringEntry : MAPs.entrySet()) {
            maps.put(stringEntry.getKey(), stringEntry.getValue()[0]);
        }
        return themeService.update(maps);
    }

    @PostMapping("/delete")
    public RespModel deleteTheme(int id) {
        return themeService.deleteTheme(id);
    }

    // @GetMapping("/love")
    // public RespModel love(int id) {
    //     return themeService.love(id);
    // }
}
