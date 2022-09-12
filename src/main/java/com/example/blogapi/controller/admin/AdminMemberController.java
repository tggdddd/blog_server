package com.example.blogapi.controller.admin;

import com.example.blogapi.pojo.LoginResp;
import com.example.blogapi.pojo.Member;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.HttpApiSessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName MemberController
 * @Description
 * @Author 15014
 * @Time 2022/9/11 21:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/member")
public class AdminMemberController {

    @Resource
    HttpApiSessionService httpApiSessionService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public RespModel login() {
        // TODO 登录


        // 生成token
        String token = httpApiSessionService.geneJsonWebToken("123", "测试用户名");
        return new RespModel(RespCode.SUCCESS, new LoginResp("123", token, Math.ceil(new Date().getTime() / 1000) + 24 * 60 * 60));
    }

    @GetMapping("/getCurUserInfo")
    public RespModel getAppUserInfo() {
        // 拿userId与userName
        String userId = httpApiSessionService.getCurrentUserId();
        String username = httpApiSessionService.getCurrentUsername();
        return new RespModel(RespCode.SUCCESS, new Member(userId, username, null));
    }
}
