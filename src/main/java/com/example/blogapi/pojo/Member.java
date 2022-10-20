package com.example.blogapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Member
 * @Description
 * @Author 15014
 * @Time 2022/9/11 22:15
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String account;
    private String password;
}
