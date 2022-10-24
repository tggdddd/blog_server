package com.example.blogapi.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @ClassName RespModel
 * @Description
 * @Author 15014
 * @Time 2022/9/7 20:49
 * @Version 1.0
 */
public class RespModel {
    String code;
    String msg;
    Object data;

    public RespModel(RespCode respCode, Object data) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
        this.data = data;
    }

    public RespModel(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }
}
