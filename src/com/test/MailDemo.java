package com.test;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.entity.User;

public class MailDemo {
	
	public static void sendEmail(User user) throws Exception {
		/*
		 * 1. 得到session
		 */
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");//设置服务器名称，使用163邮箱发送
		props.setProperty("mail.smtp.auth", "true");//设置是否需要认证，true为需要认证
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("13052307692", "langsin123");
			}
		};
		Session session = Session.getInstance(props, auth);
		
		/*
		 * 2. 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("13052307692@163.com"));//设置发件人
		msg.setRecipients(RecipientType.TO, user.getEmail());//设置收件人
		
		
		msg.setSubject("来自xxx的激活邮件");
		msg.setContent("<a href='http://localhost:8080/webProject/activate.jsp'>点击完成激活</a>！", "text/html;charset=utf-8");
		
		/*
		 * 3. 发
		 */
		Transport.send(msg);
		System.out.println("发送完成");
	}
	
	
	 

}
