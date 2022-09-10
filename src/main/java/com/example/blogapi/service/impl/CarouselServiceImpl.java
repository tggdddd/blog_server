package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.CarouselMapper;
import com.example.blogapi.mapper.TagMapper;
import com.example.blogapi.pojo.ArticleEntity;
import com.example.blogapi.pojo.CarouselEntity;
import com.example.blogapi.pojo.TagEntity;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.CarouselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Resource
    CarouselMapper carouselMapper;

    @Override
    public RespModel addCarousel(CarouselEntity carouselEntity) {
        if(carouselMapper.addCarouselEntity(carouselEntity)!=0){
            return new RespModel(RespCode.SUCCESS,carouselEntity);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel pullCarousel() {
        List<CarouselEntity> res = carouselMapper.pullCarsousel();
        if(res!=null){
            return new RespModel(RespCode.SUCCESS,res);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel updateCarousel(CarouselEntity carouselEntity) {
        if(carouselMapper.updateCarousel(carouselEntity)!=0){
            return new RespModel(RespCode.SUCCESS,carouselEntity);
        }
        return new RespModel(RespCode.FAILURE,null);
    }

    @Override
    public RespModel deleteCarousel(int id) {
        if(carouselMapper.deleteCarousel(id)!=0){
            return new RespModel(RespCode.SUCCESS,id);
        }
        return new RespModel(RespCode.FAILURE,null);
    }
}