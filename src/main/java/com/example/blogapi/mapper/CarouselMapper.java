package com.example.blogapi.mapper;

import com.example.blogapi.pojo.CarouselEntity;
import com.example.blogapi.pojo.TagEntity;

import java.util.List;

public interface CarouselMapper {
    /**
     * 增加轮播图
     *
     * @param carouselEntity
     * @return
     */
    int addCarouselEntity(CarouselEntity carouselEntity);

    /**
     * 获取轮播图
     *
     * @return
     */
    List<CarouselEntity> pullCarsousel();

    /**
     * 修改轮播图
     */
    int updateCarousel(CarouselEntity carouselEntity);

    /**
     * 删除轮播图
     *
     * @param id
     */
    int deleteCarousel(int id);


}
