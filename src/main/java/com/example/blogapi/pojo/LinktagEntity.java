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

	private String id;

	private String articleId;

	
	private String tagId;


}
