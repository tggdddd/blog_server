package com.example.blogapi.mapper;

import com.example.blogapi.pojo.Member;

import java.util.List;

/**
 * @ClassName MemberMapper
 * @Description
 * @Author 15014
 * @Time 2022/9/14 14:34
 * @Version 1.0
 */
public interface MemberMapper {
    /**
     * 添加账号
     */
    Integer addMember(Member member);

    /**
     * 查询所有账号
     */
    List<Member> getMembers();


    /**
     * 通过账号修改密码
     */
    Integer modifyPassword(Member member);

    /**
     * 校验账号
     */
    Integer validateMember(Member member);

    /**
     * 删除账号
     */
    Integer deleteMember(Member member);
}
