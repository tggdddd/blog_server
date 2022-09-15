package com.example.blogapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SumEntity
 * @Description
 * @Author 15014
 * @Time 2022/9/11 14:52
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SumEntity {
    /*文章发布的总数*/
    private Integer articleTotal;
    // 网站访问次数
    private Integer visitTotal;
    // 评论总次数
    private Integer commentTotal;
}
