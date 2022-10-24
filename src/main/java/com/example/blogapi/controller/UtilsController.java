package com.example.blogapi.controller;

import com.example.blogapi.utils.JPEGcompress;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName UtilsController
 * @Description
 * @Author 15014
 * @Time 2022/10/22 14:36
 * @Version 1.0
 */
@RestController
public class UtilsController {
    private static final HashMap<String, byte[]> bytesMap = new HashMap();
    private final HashSet<String> accept = new HashSet<String>() {{
        add("png");
        add("jpeg");
        add("jpg");
    }};

    private static void saveBytes(String fileName, byte[] bytes) {
        bytesMap.put(fileName, bytes);
    }

    private static byte[] getBytes(String fileName) {
        byte[] bytes = bytesMap.get(fileName);
        if (bytes == null) {
            return null;
        } else {
            bytesMap.remove(fileName);
            return bytes;
        }
    }

    /**
     * png与jpeg图片的有损压缩
     */
    @PostMapping("/ImageCompress")
    public String compress(@RequestParam(value = "file") MultipartFile file, float quality, HttpServletResponse response) throws IOException {
        // 判断非空
        if (file == null) {
            response.setStatus(500);
            return "读取不到文件";
        }
        // 判断文件格式是否正确
        String originFileName = file.getOriginalFilename();
        String[] fileName = originFileName.split("\\.");
        if (fileName.length != 2 || !accept.contains(fileName[1].toLowerCase())) {
            response.setStatus(500);
            return "文件名非法";
        }
        String finalName = fileName[0] + ".jpeg";
        saveBytes(finalName, JPEGcompress.compress(file.getInputStream(), "png".equalsIgnoreCase(fileName[1]), quality));
        return finalName;
    }

    @GetMapping("/getFile/{fileName}")
    public byte[] getFile(@PathVariable String fileName, HttpServletResponse response) {
        // response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        response.addHeader("content-type", MediaType.IMAGE_JPEG_VALUE);
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
        return getBytes(fileName);
    }
}
