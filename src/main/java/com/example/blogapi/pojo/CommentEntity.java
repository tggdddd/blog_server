package com.example.blogapi.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String email;
	
	private String name;

	private String describe;

	private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    private int parentId;

    private int articleId;

    // 子评论
    private List<CommentEntity> children;

    // 文章的标题 管理页面使用
    private String title;
}
