package com.example.blogapi.controller;

import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.GradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName GradeController
 * @Description
 * @Author 15014
 * @Time 2022/9/9 19:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/grade")
public class GradeController {
    @Resource
    GradeService gradeService;

    @GetMapping("/add")
    public RespModel addGrade(@RequestParam(name = "id") int articleId) {
        return gradeService.addGrade(articleId);
    }

    // @GetMapping("/delete")
    // public RespModel deleteGrade(@RequestParam(name = "id") int articleId){
    //     return gradeService.deleteGrade(articleId);
    // }

    @GetMapping("/update")
    public RespModel updateGrade(@RequestParam(name = "id") int articleId, @RequestParam(name = "grade") int point) {
        return gradeService.updateGrade(articleId, point);
    }

    @GetMapping("/get")
    public RespModel getGrade(@RequestParam(name = "id") int articleId) {
        return gradeService.getGrade(articleId);
    }
}
