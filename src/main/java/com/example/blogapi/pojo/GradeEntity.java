package com.example.blogapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName GradeEntity
 * @Description
 * @Author 15014
 * @Time 2022/9/9 18:57
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int cGrade;
    private int count;
}
