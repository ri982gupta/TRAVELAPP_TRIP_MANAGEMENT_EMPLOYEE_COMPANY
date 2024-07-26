//package com.example.mypkg.service;
//
//import java.io.FileWriter;
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import com.example.mypkg.model.EmailDetails;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    public void sendEmail(String recipient, String subject, String body) {
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        try {
//            helper.setTo(recipient);
//            helper.setSubject(subject);
//            helper.setText(body);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        javaMailSender.send(message);
//    }
//
//    public void saveEmailDetailsToJson(String recipient, String subject, String body) {
//        EmailDetails emailDetails = new EmailDetails(recipient, subject, body);
//        try (FileWriter file = new FileWriter("emails.json")) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.writeValue(file, emailDetails);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
