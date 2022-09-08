package com.example.blogapi.controller;


import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Resource
    private TagService tagService;

    @ResponseBody
    @PostMapping("/add")
    public RespModel add(@RequestBody TagEntity tag){
        return tagService.addTag(tag);
    }
    @ResponseBody
    @GetMapping("/find/{id}")
    public RespModel findByLinkId(@PathVariable int id){
        return tagService.findByLinkId(id);
    }

}
