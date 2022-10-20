package com.example.blogapi.service.impl;

import com.example.blogapi.mapper.CommentMapper;
import com.example.blogapi.pojo.CommentEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CommentServiceImplTest
 * @Description
 * @Author 15014
 * @Time 2022/9/9 20:45
 * @Version 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
class CommentServiceImplTest {
    @Resource
    CommentMapper commentMapper;
    @Test
    void findCommentByArticleId() {
    }

    @Test
    void findCommentByCommentId() {
        List<CommentEntity> list = commentMapper.findCommentByCommentId(2);

    }
}