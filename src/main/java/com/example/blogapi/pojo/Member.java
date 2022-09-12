package com.example.blogapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Member {
    private String id;
    private String account;
    private String password;
}
