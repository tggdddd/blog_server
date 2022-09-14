package com.example.blogapi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName DraftEntity
 * @Description
 * @Author 15014
 * @Time 2022/9/14 9:14
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DraftEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private String title;

    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;


    private String content;
}
