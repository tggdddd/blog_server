package com.example.blogapi.utils;

import com.example.blogapi.service.MailService;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @ClassName MailUtil
 * @Description
 * @Author 15014
 * @Time 2022/9/15 9:25
 * @Version 1.0
 */
public class MailUtil {
    @Resource
    MailService mailService;

    public void sendSimpleMail(String to, String url) {
        mailService.sendSimpleMail(to, "收到一个回复——来自blog", "您在博客上的评论被回复了，点击" + url + "查看回复的内容");
    }

    public void sendHtmlMail() throws MessagingException {

        String content = "<html>\n" +
                "<body>\n" +
                "<h3>hello world</h3>\n" +
                "<h1>html</h1>\n" +
                "<body>\n" +
                "</html>\n";

        mailService.sendHtmlMail("ispringboot@163.com", "这是一封HTML邮件", content);
    }

    public void sendAttachmentsMail() throws MessagingException {
        String filePath = "/ijiangtao/软件开发前景.docx";
        String content = "<html>\n" +
                "<body>\n" +
                "<h3>hello world</h3>\n" +
                "<h1>html</h1>\n" +
                "<h1>附件传输</h1>\n" +
                "<body>\n" +
                "</html>\n";
        mailService.sendAttachmentsMail("ispringboot@163.com", "这是一封HTML邮件", content, filePath);
    }

    public void sendInlinkResourceMail() throws MessagingException {
        // TODO 改为本地图片目录
        String imgPath = "/ijiangtao/img/blob/dd9899b4cf95cbf074ddc4607007046c022564cb/blog/animal/dog/dog-at-work-with-computer-2.jpg?raw=true";
        String rscId = "admxj001";
        String content = "<html>" +
                "<body>" +
                "<h3>hello world</h3>" +
                "<h1>html</h1>" +
                "<h1>图片邮件</h1>" +
                "<img src='cid:" + rscId + "'></img>" +
                "<body>" +
                "</html>";

        mailService.sendInlinkResourceMail("ispringboot@163.com", "这是一封图片邮件", content, imgPath, rscId);
    }
}