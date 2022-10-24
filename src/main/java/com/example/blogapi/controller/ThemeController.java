package com.example.blogapi.controller;

import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.MailService;
import com.example.blogapi.service.ThemeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName ThemeController
 * @Description
 * @Author 15014
 * @Time 2022/9/15 16:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/theme")
public class ThemeController {
    @Resource
    ThemeService themeService;
    @Resource
    MailService mailService;
    /**
     * 返回所有的主题
     */
    @GetMapping("/all")
    public RespModel getThemes() {
        return themeService.getThemes();
    }

    @PostMapping("/add")
    public RespModel addThemes(@RequestBody Map<String, String> map) {
        RespModel respModel = themeService.addThemes(map);
        if (respModel.getCode() == "200") {
            mailService.sendSimpleMail("15014586591@139.com", "blog新增了一个主题——来自blog", map.get("author") + "在您在博客上新增了主题  " + map.get("name") + "---");
        }
        return respModel;
    }

    @GetMapping("/love")
    public RespModel love(int id) {
        return themeService.love(id);
    }

    @GetMapping("/defaultId")
    public RespModel defaultId() {
        return themeService.defaultId();
    }
}
