package com.example.blogapi.controller.admin;


import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/tag")
public class AdminTagController {
    @Resource
    private TagService tagService;

    @RequestMapping("/all")
    public RespModel getAllTag() {
        return tagService.getAllTag();
    }

    @PostMapping("/add")
    public RespModel add(TagEntity tag) {
        return tagService.addTag(tag);
    }

    @GetMapping("/find/{id}")
    public RespModel findByLinkId(@PathVariable int id) {
        return tagService.findByLinkId(id);
    }

    /**
     * 通过文章ID修改文章
     */
    @PostMapping("/update")
    public RespModel updateTag(TagEntity tagEntity) {
        return tagService.updateTag(tagEntity);
    }

    /**
     * 删除标题
     *
     * @param id Id
     */
    @PostMapping("/delete")
    public RespModel deleteTag(int id) {
        return tagService.removeTag(id);
    }
}
