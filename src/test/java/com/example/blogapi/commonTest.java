package com.example.blogapi;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.junit.Ignore;
import org.junit.Test;

import java.util.UUID;

/**
 * @ClassName commonTest
 * @Description
 * @Author 15014
 * @Time 2022/10/20 15:28
 * @Version 1.0
 */
@Ignore
public class commonTest {

    private String accessKey = "G6cerIQacjqaYvvxz3f6Vp_gAUEhxGXKVcgHbxP8";

    private String secretKey = "SxFV6ARUzGLx8ywCRrsKgQVo5SZ4JvRU_WrbvPmT";

    private String imgBucketName = "blog-api-space";

    @Test
    public void testUUID() {
        System.out.println(UUID.randomUUID());
    }

    @Test
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
}