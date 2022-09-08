package com.example.blogapi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinktagEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private int articleId;

	
	private int tagId;


}
