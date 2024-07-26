//package com.example.mypkg.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping; // Import the necessary annotation
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import java.io.FileWriter;
//import java.io.IOException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.example.mypkg.model.EmailDetails;
//import com.example.mypkg.service.EmailService;
//
//@RestController
//public class EmailController {
//
//    @Autowired
//    private EmailService emailService;
//
//    @PostMapping("/send-email-to-supervisor")
//    public void sendEmailToSupervisor(@RequestBody EmailDetails emailDetails) {
//        String recipient = emailDetails.getRecipient();
//        String subject = emailDetails.getSubject();
//        String body = emailDetails.getBody();
//
//        // Send email
//        emailService.sendEmail(recipient, subject, body);
//
//        // Save email details to JSON file
//        saveEmailDetails(emailDetails);
//    }
//
//    @GetMapping("/get-email-details") // New method for handling GET requests
//    public EmailDetails getEmailDetails() {
//        // In a real-world scenario, you would retrieve email details from your data source
//        // For demonstration purposes, I'll create a dummy EmailDetails object
//        EmailDetails dummyEmail = new EmailDetails();
//        dummyEmail.setRecipient("supervisor@example.com");
//        dummyEmail.setSubject("Regarding Project Update");
//        dummyEmail.setBody("Dear Supervisor, ...");
//
//        return dummyEmail;
//    }
//
//    private void saveEmailDetails(EmailDetails emailDetails) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String emailDetailsJson = objectMapper.writeValueAsString(emailDetails);
//
//            // Write JSON string to file
//            FileWriter fileWriter = new FileWriter("emails.json", true); // Append mode
//            fileWriter.write(emailDetailsJson);
//            fileWriter.write("\n"); // Add newline for next entry
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Handle exception (e.g., log error, return error response)
//        }
//    }
//}
