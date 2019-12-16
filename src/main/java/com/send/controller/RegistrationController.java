package com.send.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.send.domain.User;
import com.send.service.NotificationService;

@RestController
public class RegistrationController {
	
	private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/signup")
	public String signUp() {
		return "Please sign up for our service";
	}
	@RequestMapping("/singup-success")
	public String signUpSuccess() {
		
		// create a user
		User user = new User();
		user.setFirstName("micheal");
		user.setLastName("Jackson");
		user.setEmailAddress("xxxx@xxx.com");
		
		try {
			notificationService.sendNotification(user);
		}catch(MailException e) {
			logger.info("Error sending mail : " + e.getMessage());
		}
		
		return "thank you registering with us";
	}
}
