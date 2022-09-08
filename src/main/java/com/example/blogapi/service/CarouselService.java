package com.example.blogapi.service;


import com.example.blogapi.pojo.CarouselEntity;
import com.example.blogapi.resp.RespModel;

import java.util.List;

public interface CarouselService {

    /**
     * 增加轮播图
     *
     * @param carouselEntity
     * @return
     */
    RespModel addCarousel(CarouselEntity carouselEntity);

    /**
     * 获取轮播图
     *
     * @return
     */
    RespModel pullCarousel();

    /**
     * 修改轮播图
     */
    RespModel updateCarousel(CarouselEntity carouselEntity);

    /**
     * 删除轮播图
     *
     * @param id
     */
    RespModel deleteCarousel(int id);


}

