package com.example.blogapi.utils;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * @ClassName QiniuUtil
 * @Description
 * @Author 15014
 * @Time 2022/10/20 12:30
 * @Version 1.0
 */
@Component
@ConfigurationProperties
public class QiniuUtil {

    private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);
    @Value("${qiniu.key.access}")
    private String accessKey;

    @Value("${qiniu.key.secret}")
    private String secretKey;

    @Value("${qiniu.bucket.img.name}")
    private String imgBucketName;

    @Value("${qiniu.bucket.img.url}")
    private String imgBucketUrl;

    /**
     * 获得七牛云文件图片列表
     */
    public JSONObject getImageFileList() {
        BucketManager bucketManager = new BucketManager(Auth.create(accessKey, secretKey), new Configuration(Zone.huanan()));
        BucketManager.FileListIterator iterator = bucketManager.createFileListIterator(imgBucketName, "");
        ArrayList<FileInfo> list = new ArrayList<>();
        while (iterator.hasNext()) {
            FileInfo[] items = iterator.next();
            for (FileInfo item : items) {
                if (item.mimeType.contains("image")) {
                    list.add(item);
                }
            }
        }
        JSONObject object = new JSONObject();
        object.put("url", imgBucketUrl);
        object.put("list", list);
        return object;
    }

    public boolean delete(String fileName) {
        BucketManager bucketManager = new BucketManager(Auth.create(accessKey, secretKey), new Configuration(Zone.huanan()));
        try {
            Response response = bucketManager.delete(imgBucketName, fileName);
            return true;
        } catch (QiniuException e) {
            logger.error(e.response.toString());
            return false;
        }
    }

    /**
     * 上传文件到七牛云
     */
    public boolean upload(InputStream inputStream, String fileName, String suffix) {
        // 判断非空
        if (inputStream == null || StringUtil.isEmpty(fileName) || StringUtil.isEmpty(suffix)) {
            logger.error("文件流不存在!文件名字不能为空！");
            return false;
        }
        // 设置响应信息
        StringMap policy = new StringMap();
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        policy.put("returnBody", json.toJSONString());
        // 生成上传凭证
        Auth auth = Auth.create(accessKey, secretKey);
        String uploadToken = auth.uploadToken(imgBucketName, fileName, 3600, policy);
        // 指定上传机房
        UploadManager manager = new UploadManager(new Configuration(Zone.huanan()));
        try {
            // 开始上传图片
            Response response = manager.put(inputStream, fileName, uploadToken, null, "image/" + suffix);
            // 处理响应结果
            json = JSONObject.parseObject(response.bodyString());
            if (json == null || json.get("code") == null || !json.get("code").toString().equals("0")) {
                logger.info(String.format("文件上传失败[%s].", fileName));
                return false;
            } else {
                logger.info(String.format("文件上传成功[%s].", fileName));
                return true;
            }
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }
}

