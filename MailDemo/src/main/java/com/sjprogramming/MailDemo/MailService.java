//package com.sjprogramming.MailDemo;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String fromMail;
//
//    public void sendMail(String to, MailStructure mailStructure) {
//        try {
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setFrom(fromMail);
//            helper.setTo(to);
//            helper.setSubject(mailStructure.getSubject());
//            helper.setText(mailStructure.getMessage(), true);
//            mailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            // Handle any exceptions, for example log them
//            e.printStackTrace();
//            throw new RuntimeException("Failed to send email");
//        }
//    }
//}



//package com.sjprogramming.MailDemo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("$(spring.mail.username)")
//    private String fromMail;
//    
//    public void sendMail(String mail, MailStructure mailStructure) {
//    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//    	simpleMailMessage.setFrom(fromMail);
//    	simpleMailMessage.setSubject(mailStructure.getSubject());
//    	simpleMailMessage.setText(mailStructure.getMessage());
//    	simpleMailMessage.setTo(mail);
//    	mailSender.send(simpleMailMessage);
//    }
//}




//package com.sjprogramming.MailDemo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String fromMail;
//
//    public void sendMail(String to, MailStructure mailStructure) {
//        try {
//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage.setFrom(fromMail);
//            simpleMailMessage.setTo(to);
//            simpleMailMessage.setSubject(mailStructure.getSubject());
//            simpleMailMessage.setText(mailStructure.getMessage());
//            mailSender.send(simpleMailMessage);
//        } catch (Exception e) {
//            // Handle any exceptions, for example log them
//            e.printStackTrace();
//            throw new RuntimeException("Failed to send email");
//        }
//    }
//}




//-----------------------------------------mail request-------------------------------------------------


package com.sjprogramming.MailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendMail(String to, MailStructure mailStructure) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(fromMail);
            helper.setTo(to);
            helper.setSubject(mailStructure.getSubject());
            helper.setText(mailStructure.getMessage(), true); // true indicates HTML content
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send email");
        }
    }
}

