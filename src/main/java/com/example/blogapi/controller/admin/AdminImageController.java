package com.example.blogapi.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.example.blogapi.resp.RespCode;
import com.example.blogapi.resp.RespModel;
import com.example.blogapi.utils.QiniuUtil;
import com.example.blogapi.utils.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @ClassName ImageController
 * @Description 七牛云的文件管理
 * @Author 15014
 * @Time 2022/10/20 15:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/image")
public class AdminImageController {
    @Resource
    QiniuUtil qiniuUtil;
    @Value("${qiniu.bucket.img.url}")
    private String imgBucketUrl;

    /* 获取图片列表 */
    @GetMapping("imgList")
    public RespModel getImageList() {
        JSONObject object = qiniuUtil.getImageFileList();
        return new RespModel(RespCode.SUCCESS, object);
    }

    /* 删除文件 */
    @PostMapping("delete")
    public RespModel deleteFile(String fileName) {
        if (StringUtil.isEmpty(fileName)) {
            return new RespModel(RespCode.IS_BLANK, null);
        }
        boolean result = qiniuUtil.delete(fileName);
        return new RespModel(result ? RespCode.SUCCESS : RespCode.FAILURE, null);
    }

    /**
     * 上传图片到七牛云
     */
    @PostMapping("uploadImg")
    public RespModel uploadImage(MultipartFile file) {
        // 文件不能为空
        if (file == null) {
            return new RespModel(RespCode.IS_BLANK, null);
        }
        // 需要有文件后缀
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        if (suffix.trim().isEmpty()) {
            return new RespModel(RespCode.IS_BLANK, null);
        }
        // 生成随机文件名
        fileName = StringUtil.generateUUID() + suffix;
        try {
            // 上传
            boolean result = qiniuUtil.upload(file.getInputStream(), fileName, suffix);
            return new RespModel(result ? RespCode.SUCCESS : RespCode.FAILURE, imgBucketUrl + "/" + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
