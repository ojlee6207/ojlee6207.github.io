package com.kh.email.model.vo;

import lombok.Data;

@Data
public class EmailDetail {

	private String subject;
	private String content;
	private String receiver;
	private String filename;
	
}