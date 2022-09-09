package com.example.blogapi.mapper;

import com.example.blogapi.pojo.TagEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    /**
     * 增加标签
     * @param tag
     * @return
     */
    int addTag(TagEntity tag);

    /**
     * 通过文章ID查询标签
     * @param id
     * @return
     */
    List<TagEntity> findByLinkId(int id);

    /**
     * 修改标签
     */
    int updateTag(TagEntity tag);

    /**获得所有标签*/
    List<TagEntity> getAllTag();

}
