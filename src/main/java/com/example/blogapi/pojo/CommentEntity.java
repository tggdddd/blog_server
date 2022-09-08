package com.example.blogapi.pojo;


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

	
	private Date date;

	private int parentId;
	
	private int articleId;

	//子评论
	private List<CommentEntity> subComment;
}
