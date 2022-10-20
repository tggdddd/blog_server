package com.example.blogapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName LoginResp
 * @Description
 * @Author 15014
 * @Time 2022/9/11 22:19
 * @Version 1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResp {
    private static final long serialVersionUID = 1L;
    private String account;

    private String token;

    private double failure_time;
}
