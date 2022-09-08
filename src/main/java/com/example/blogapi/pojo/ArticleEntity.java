package com.example.blogapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String title;

	private String author;

	private Date date;


	private String content;

	private Integer browse;


}
