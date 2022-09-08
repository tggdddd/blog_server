package com.example.blogapi.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
/**
 * @ClassName respCode
 * @Description
 * @Author 15014
 * @Time 2022/9/7 14:04
 * @Version 1.0
 */
public enum RespCode {
    SUCCESS("200","请求成功"),
    FAILURE("999","网络异常");
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
