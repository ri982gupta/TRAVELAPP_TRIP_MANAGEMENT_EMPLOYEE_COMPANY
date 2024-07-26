package com.example.mypkg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.mypkg.model.TravelRequestDTO;

@RestController
public class TravelRequestDTOController {
	
	private final JavaMailSender emailSender;

    public TravelRequestDTOController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping("/travel-request")
    public ResponseEntity<String> sendTravelRequest(@RequestBody TravelRequestDTO request) {
        try {
            // Send email
            sendEmail(request);
            return ResponseEntity.ok("Travel request sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send travel request");
        }
    }

    private void sendEmail(TravelRequestDTO request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("manager@example.com"); // Replace with the manager's email address
        message.setSubject("Travel Request");
        message.setText("Destination: " + request.getDestination() + "\nDate: " + request.getDate());
        emailSender.send(message);
    }

}
