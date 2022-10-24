package com.example.blogapi;

import com.alibaba.fastjson.JSONObject;
import com.example.blogapi.utils.JPEGcompress;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @ClassName commonTest
 * @Description
 * @Author 15014
 * @Time 2022/10/20 15:28
 * @Version 1.0
 */

public class commonTest {

    private static String accessKey = "G6cerIQacjqaYvvxz3f6Vp_gAUEhxGXKVcgHbxP8";

    private static String secretKey = "SxFV6ARUzGLx8ywCRrsKgQVo5SZ4JvRU_WrbvPmT";

    private static String imgBucketName = "blog-api-space";
    private static String fileBucketName = "files-spaces";

    public static void ssss(File file) throws IOException {
        if (file == null) {
            String path = "C:\\Users\\15014\\Desktop\\live2d_api\\";
            File file22 = new File(path);
            File[] files = file22.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file1 = files[i];
                ssss(file1);
            }
            return;
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file1 = files[i];
                ssss(file1);
            }
            return;
        }
        FileInputStream inputStream = new FileInputStream(file);
        String mimeType = Files.probeContentType(file.toPath());
        String fileName = file.getAbsolutePath().substring("C:\\Users\\15014\\Desktop\\".length());
        char[] chars = fileName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\\') {
                chars[i] = '/';
            }
        }
        fileName = String.copyValueOf(chars);
        uploadFile(inputStream, fileName, mimeType);
        inputStream.close();
    }

    /**
     * 上传文件到七牛云
     */

    public static boolean uploadFile(InputStream inputStream, String fileName, String type) {
        // 设置响应信息
        StringMap policy = new StringMap();
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        policy.put("returnBody", json.toJSONString());
        // 生成上传凭证
        Auth auth = Auth.create(accessKey, secretKey);
        String uploadToken = auth.uploadToken(fileBucketName, fileName, 3600, policy);
        // 指定上传机房
        UploadManager manager = new UploadManager(new Configuration(Zone.huanan()));
        try {
            // 开始上传图片
            Response response = manager.put(inputStream, fileName, uploadToken, null, type);
            // 处理响应结果
            json = JSONObject.parseObject(response.bodyString());
            if (json == null || json.get("code") == null || !json.get("code").equals("0")) {
                System.out.printf("文件%s成功上传", fileName);
                return true;
            } else {
                System.out.printf("文件%s上传失败", fileName);
                System.out.println(response.bodyString());
                return false;
            }
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Ignore
    public void testUUID() {
        System.out.println(UUID.randomUUID());
    }

    /* 测试压缩图片 */
    @Test
    @Ignore
    public void testJPEGCompress() throws IOException {
        File file = new File("C:\\Users\\15014\\Desktop\\新建文件夹\\1.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = JPEGcompress.compress(fileInputStream, false, (float) 1);
        FileOutputStream os = new FileOutputStream("d.jpg");
        os.write(bytes);
        os.close();
    }

    @Test
    @Ignore
    public void testPNGCompress() throws IOException {
        File file = new File("C:\\Users\\15014\\Desktop\\未标题-1.png");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytess = JPEGcompress.compress(fileInputStream, true, (float) 1);
        FileOutputStream os = new FileOutputStream("2.jpeg");
        os.write(bytess);
        os.close();
    }

    @Test
    @Ignore
    public void testDelete() {
        BucketManager bucketManager = new BucketManager(Auth.create(accessKey, secretKey), new Configuration(Region.region0()));
        try {
            Response response = bucketManager.delete(imgBucketName, "1.png");
            System.out.println(response.bodyString());
        } catch (QiniuException e) {
            System.err.println(e.code());
            System.err.println(e.response.toString());
        }
    }

    @Test
    @Ignore
    public void testBucketFileList() throws QiniuException {
        BucketManager bucketManager = new BucketManager(Auth.create(accessKey, secretKey), new Configuration(Zone.huanan()));
        BucketManager.FileListIterator strings = bucketManager.createFileListIterator("myspace17", "");
        while (strings.hasNext()) {
            FileInfo[] items = strings.next();
            for (FileInfo item : items) {
                System.out.println(item.key);
                System.out.println(item.hash);
                System.out.println(item.fsize);
                System.out.println(item.mimeType);
                System.out.println(item.putTime);
                System.out.println(item.endUser);
            }
            System.out.println("dddd");
        }
    }

    @Test
    @Ignore
    public void aa() throws IOException {
        ssss(null);
    }
}