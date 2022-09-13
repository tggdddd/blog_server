package com.example.blogapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName TagsIds
 * @Description
 * @Author 15014
 * @Time 2022/9/13 18:33
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagsId {
    private List<Integer> tagsId;
}
