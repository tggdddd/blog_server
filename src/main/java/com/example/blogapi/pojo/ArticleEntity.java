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
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String title;

	private String author;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date date;


	private String content;

	private Integer browse;

	//额外的属性
	private List<TagEntity> tags;
}
