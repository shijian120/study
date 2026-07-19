package com.sj.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

/**
 * ClassName: MailTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/26 12:11
 * @Version 1.0
 */

@SpringBootTest
public class MailTest {
	
	@Autowired
	JavaMailSender sender;
	
	/*
	发送简单邮件
		1.只有主题和正文
		2. 无法发送图片，附件等
	 */
	@Test
	public void testSimple(){
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("邮件标题");
		simpleMailMessage.setText("邮件正文");
		simpleMailMessage.setTo("596626897@qq.com"); //收件地址
		simpleMailMessage.setFrom("1264839800@qq.com");  // 发件地址
		
		
		sender.send(simpleMailMessage);
		
		System.out.println("邮件发送完毕");
		
	}
	
	// 发送邮件携带图片
	@Test
	public void testSendMimeMail() throws MessagingException {
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		
		helper.setSubject("主题");
		/*
		true,代表解析 html
		如果不写 默认是false  html会原文显示，不会解析
		 */
		helper.setText("正文"+"<img src='' ></img>",true);
		helper.setFrom("发送方");
		helper.setTo("接收方");
		
		sender.send(mimeMessage);
		
		System.out.println("邮件发送完成");
	}
	
	// 发送邮件携带附件
	@Test
	public void testSendMimeMail1() throws MessagingException {
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		// 想发送附件，需要 multipart =  true
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		
		helper.setSubject("主题");
		/*
		true,代表解析 html
		如果不写 默认是false  html会原文显示，不会解析
		 */
		helper.setText("正文"+"<img src='' ></img>",true);
		helper.setFrom("发送方");
		helper.setTo("接收方");
		helper.addAttachment("附件名", new File("/ss/s.txt"));
		sender.send(mimeMessage);
		
		System.out.println("邮件发送完成");
	}
	
}
