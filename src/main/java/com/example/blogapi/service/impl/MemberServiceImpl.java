package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.MemberMapper;
import com.example.blogapi.pojo.Member;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MemberServiceImpl
 * @Description
 * @Author 15014
 * @Time 2022/9/14 15:26
 * @Version 1.0
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    MemberMapper memberMapper;

    /**
     * 添加账号
     */
    public RespModel addMember(Member member) {
        int res = memberMapper.addMember(member);
        if (res == 0) {
            return new RespModel(RespCode.ADD_FAILURE, res);
        }
        return new RespModel(RespCode.SUCCESS, res);
    }

    /**
     * 查询所有账号
     */
    public RespModel getMembers() {
        List<Member> list = memberMapper.getMembers();
        return new RespModel(RespCode.SUCCESS, list);
    }


    /**
     * 通过账号修改密码
     */
    public RespModel modifyPassword(Member member) {
        int res = memberMapper.modifyPassword(member);
        if (res == 0) {
            return new RespModel(RespCode.MOD_FAILURE, res);
        }
        return new RespModel(RespCode.SUCCESS, res);
    }

    /**
     * 校验账号
     */
    public Integer validateMember(Member member) {
        Integer res = memberMapper.validateMember(member);
        return res;
    }

    /**
     * 删除账号
     */
    public RespModel deleteMember(Member member) {
        int res = memberMapper.modifyPassword(member);
        if (res == 0) {
            return new RespModel(RespCode.DEL_FAILURE, res);
        }
        return new RespModel(RespCode.SUCCESS, res);
    }
}
