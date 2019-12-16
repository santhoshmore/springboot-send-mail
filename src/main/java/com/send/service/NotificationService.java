package com.send.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.send.domain.User;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(User user) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("xxxx@xxx.com");
		mail.setSubject("just working on GMAIL API");
		mail.setText("this is mail body");
		javaMailSender.send(mail);
	}
}
