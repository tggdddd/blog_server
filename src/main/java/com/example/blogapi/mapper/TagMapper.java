package com.example.blogapi.mapper;

import com.example.blogapi.pojo.TagEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    int addTag(TagEntity tag);
    List<TagEntity> findByLinkId(int id);
}
