package com.example.blogapi.controller.admin;

import com.example.blogapi.pojo.CarouselEntity;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.CarouselService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName CarouselController
 * @Description
 * @Author 15014
 * @Time 2022/9/8 16:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/carousel")
public class AdminCarouselController {
    @Resource
    private CarouselService carouselService;

    /**
     * 增加轮播图
     *
     * @param carouselEntity
     * @return
     */
    @PostMapping("/add")
    public RespModel add(CarouselEntity carouselEntity) {
        return carouselService.addCarousel(carouselEntity);
    }

    /**
     * 获得所有轮播图
     */
    @GetMapping("/pull")
    public RespModel pullCarousel() {
        return carouselService.pullCarousel();
    }

    /**
     * 删除轮播图
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public RespModel findByLinkId(Integer id) {
        return carouselService.deleteCarousel(id);
    }

    /**
     * 通过文章ID修改轮播图
     */
    @PostMapping("/update")
    public RespModel updateTag(CarouselEntity carouselEntity) {
        return carouselService.updateCarousel(carouselEntity);
    }
}
