package com.kh.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.blog.model.vo.BlogPost;
import com.kh.blog.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	public BlogService bService;
	
	@RequestMapping("/addPost")
	public String addBlogPost(BlogPost bp, Model model, HttpSession session) {
		
		int result = bService.addBlogPost(bp);
		
		if (result > 0) {
			session.setAttribute("alertMsg", "완료되었습니다");
		} else {
			session.setAttribute("alertMsg", "제목과 내용 입력 후 저장 가능합니다.");
		}
		return "redirect:/";
	}
}