package com.example.blogapi.controller.admin;

import com.example.blogapi.pojo.LoginResp;
import com.example.blogapi.pojo.Member;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.HttpApiSessionService;
import com.example.blogapi.service.MemberService;
import io.jsonwebtoken.Claims;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
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
    public static String mask = "wssb";
    @Resource
    MemberService memberService;

    @PostMapping("/editPassword")
    public RespModel editPassword(Member member, String newpassword) {
        // 验证账号
        String password = member.getPassword();
        password = (new Md5Hash(password, mask, 10)).toString();
        member.setPassword(password);
        Integer res = memberService.validateMember(member);
        if (res == null || res == 0) {
            return new RespModel(RespCode.PASS_ERROR, member);
        }
        newpassword = (new Md5Hash(newpassword, mask, 10)).toString();
        member.setPassword(newpassword);
        return memberService.modifyPassword(member);
    }

    /**
     * 登出 令牌立即过期
     *
     * @param request
     * @return RESP
     */
    @PostMapping("/loginOut")
    public RespModel loginOut(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Token");
        // 如果header中不存在token，则从参数中获取token
        if (token == null || StringUtils.trimAllWhitespace(token).length() == 0) {
            token = request.getParameter("Token");
        }
        // token为空返回
        if (token == null || StringUtils.trimAllWhitespace(token).length() == 0) {
            return new RespModel(RespCode.SUCCESS, null);
        } else {
            //  校验并解析token，如果token过期或者篡改，则会返回null
            Claims claims = httpApiSessionService.checkJWT(token);
            claims.setExpiration(new Date());
        }
        return new RespModel(RespCode.SUCCESS, null);
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public RespModel login(Member member) {
        // TODO 登录
        String user = member.getAccount();
        String password = member.getPassword();
        // 校验是否规范
        if (user == null || password == null || user.equals("") || password.equals("")) {
            return new RespModel(RespCode.IS_BLANK, null);
        }
        // 验证账号
        password = (new Md5Hash(password, mask, 10)).toString();
        member.setPassword(password);
        Integer res = memberService.validateMember(member);
        if (res == null || res == 0) {
            return new RespModel(RespCode.PASS_ERROR, member);
        }
        // 生成token
        String token = httpApiSessionService.geneJsonWebToken("1", user);
        return new RespModel(RespCode.SUCCESS, new LoginResp(user, token, Math.ceil(new Date().getTime() / 1000) + HttpApiSessionService.EXPIRE / 1000));
    }

    @GetMapping("/getCurUserInfo")
    public RespModel getAppUserInfo() {
        // 拿userId与userName
        String userId = httpApiSessionService.getCurrentUserId();
        String username = httpApiSessionService.getCurrentUsername();
        return new RespModel(RespCode.SUCCESS, new Member(userId, username, null));
    }

}
