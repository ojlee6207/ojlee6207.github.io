package com.kh.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.email.model.vo.EmailDetail;

import jakarta.mail.internet.MimeMessage;

@Controller
public class MailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String sender;

	@ResponseBody
	@RequestMapping("sendMail.do")
	public String sendMail(EmailDetail mail, @RequestParam(value="upfile", required=false) MultipartFile upfile) throws Exception {
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");
				
		msgHelper.setSubject(mail.getSubject());
		msgHelper.setText(mail.getContent());
		msgHelper.setTo(mail.getReceiver());
		msgHelper.setFrom(sender, "[KH] 테스트 메일");
		if (upfile!=null && !upfile.isEmpty()) {
			
			ByteArrayResource file = new ByteArrayResource(upfile.getBytes());
	        msgHelper.addAttachment(upfile.getOriginalFilename(), file);

		} 

		mailSender.send(message);
		
		return "success";
	}
}