package com.example.blogapi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @ClassName JPEGcompress
 * @Description
 * @Author 15014
 * @Time 2022/10/22 12:44
 * @Version 1.0
 */
public class JPEGcompress<P> {
    private static final Logger logger = LoggerFactory.getLogger(JPEGcompress.class);

    public static byte[] compress(InputStream inputStream, boolean isPNG, float quality) throws IOException {
        String number = StringUtil.generateNum();
        logger.info(String.format("执行图片压缩,随机编号：%s", number));
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        if (isPNG) {
            BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
                    bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
            bufferedImage = newBufferedImage;
        }
        // 得到迭代器
        Iterator<ImageWriter> iterator = ImageIO.getImageWritersByFormatName("jpg");
        // 得到writer
        ImageWriter writer = iterator.next();
        // 获得默认配置
        ImageWriteParam param = writer.getDefaultWriteParam();
        // 开启压缩
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        // 设置图片质量
        param.setCompressionQuality(quality);
        // 是否是渐进流模式
        param.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
        // 开始压缩
        // 开始打包图片，写入byte[]
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // 取得内存输出流
        try {
            // 此处因为ImageWriter中用来接收write信息的output要求必须是ImageOutput
            // 通过ImageIo中的静态方法，得到byteArrayOutputStream的ImageOutput
            writer.setOutput(ImageIO.createImageOutputStream(byteArrayOutputStream));
            writer.write(null, new IIOImage(bufferedImage, null, null), param);
        } catch (IOException e) {
            logger.error(String.format("图片压缩失败！编号：%s", number));
            e.printStackTrace();
            return null;
        }
        logger.info(String.format("图片压缩成功,随机编号：%s", number));
        return byteArrayOutputStream.toByteArray();
    }
}
