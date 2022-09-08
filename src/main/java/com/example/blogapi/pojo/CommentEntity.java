package com.example.blogapi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String email;

	
	private String name;

	private String describe;

	private String content;

	
	private Date date;

	private String parentId;

	
	private String articleId;


}
