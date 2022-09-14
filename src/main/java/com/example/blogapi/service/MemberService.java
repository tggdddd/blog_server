package com.example.blogapi.service;

import com.example.blogapi.pojo.Member;
import com.example.blogapi.resp.RespModel;

/**
 * @ClassName MemberService
 * @Description
 * @Author 15014
 * @Time 2022/9/14 15:26
 * @Version 1.0
 */
public interface MemberService {
    /**
     * 添加账号
     */
    RespModel addMember(Member member);

    /**
     * 查询所有账号
     */
    RespModel getMembers();


    /**
     * 通过账号修改密码
     */
    RespModel modifyPassword(Member member);

    /**
     * 校验账号
     */
    Integer validateMember(Member member);

    /**
     * 删除账号
     */
    RespModel deleteMember(Member member);
}
