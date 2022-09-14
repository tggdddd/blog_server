package com.example.blogapi.resp;

import lombok.AllArgsConstructor;
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
    SUCCESS("200", "请求成功"),
    IS_BLANK("777", "输入不能为空"),
    ADD_FAILURE("789", "添加失败"),
    MOD_FAILURE("788", "修改失败"),
    DEL_FAILURE("778", "删除失败"),
    FAILURE("999", "网络异常"),
    PASS_ERROR("100", "账号密码错误"),

    PERMISSION_ERROR("000", "没有权限！"),

    TOKEN_FAIL("321", "登陆失效， 请重新登陆");
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
