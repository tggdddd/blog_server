package com.example.blogapi.fillter;

import com.alibaba.fastjson.JSONObject;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.service.HttpApiSessionService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static com.example.blogapi.service.HttpApiSessionService.USER_ID_KEY;
import static com.example.blogapi.service.HttpApiSessionService.USER_USERNAME_KEY;

@Slf4j
@WebFilter(filterName = "authFilter", urlPatterns = "/admin/*")
@Order(1)
public class AuthFilter implements Filter {
    /**
     * 白名单
     */
    private static final String[] whiteList = {"/admin/member/login"};
    @Resource
    HttpApiSessionService httpApiSessionService;

    // 需要拦截的地址
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        log.info(req.getMethod());
        if (Objects.equals(req.getMethod(), "OPTIONS")) {
            return;
        }
        String url = req.getRequestURI();
        if (Arrays.asList(whiteList).contains(url)) {
            chain.doFilter(request, response);
            return;
        } else {
            // 拦截接口
            // 从header中获取token
            String token = req.getHeader("Token");
            // 如果header中不存在token，则从参数中获取token
            if (token == null || StringUtils.trimAllWhitespace(token).length() == 0) {
                token = request.getParameter("Token");
            }
            // token为空返回
            if (token == null || StringUtils.trimAllWhitespace(token).length() == 0) {
                responseResult(resp, new RespModel(RespCode.PERMISSION_ERROR, "token不能为空"));
                return;
            }
            //  校验并解析token，如果token过期或者篡改，则会返回null
            Claims claims = httpApiSessionService.checkJWT(token);
            if (null == claims) {
                responseResult(resp, new RespModel(RespCode.TOKEN_FAIL, "登陆失效， 请重新登陆"));
                return;
            }
            // TODO 校验用户状态等

            //  校验通过后，设置用户信息到request里，在Controller中从Request域中获取用户信息
            request.setAttribute(USER_ID_KEY, claims.get(USER_ID_KEY));
            request.setAttribute(USER_USERNAME_KEY, claims.get(USER_USERNAME_KEY));
            chain.doFilter(request, response);
        }

    }

    /**
     * responseResult
     *
     * @param response
     * @param result
     */
    private void responseResult(HttpServletResponse response, RespModel result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSONObject.toJSONString(result));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
}
