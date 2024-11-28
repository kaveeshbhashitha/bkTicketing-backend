package com.bkticketing.bkTicketing_backend.ServiceImplementation;
<<<<<<< HEAD
=======
import com.bkticketing.bkTicketing_backend.Model.Email;
import com.bkticketing.bkTicketing_backend.Repository.EmailRepository;
import com.bkticketing.bkTicketing_backend.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> origin/main

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bkticketing.bkTicketing_backend.Model.Email;
import com.bkticketing.bkTicketing_backend.Repository.EmailRepository;
import com.bkticketing.bkTicketing_backend.Service.EmailService;

@Service
public class EmailServiceImplementation implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailRepository emailRepository;

    public String sendAndSaveEmail(String toEmail, String subject, String body) {
        Email emailRecord = new Email();
        try {
            // Send email
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("pharmaforjob@gmail.com");
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);

            // Set email details for saving
            emailRecord.setToEmail(toEmail);
            emailRecord.setSubject(subject);
            emailRecord.setBody(body);
            emailRecord.setStatus("SENT");

            // Save email record
            emailRepository.save(emailRecord);
            return "Email sent successfully.";

        } catch (Exception e) {
            emailRecord.setToEmail(toEmail);
            emailRecord.setSubject(subject);
            emailRecord.setBody(body);
            emailRecord.setStatus("FAILED");

            emailRepository.save(emailRecord);
            return "Failed to send email.";
        }
    }

=======
@Service
public class EmailServiceImplementation implements EmailService {
    @Autowired
    private EmailRepository emailRepository;
    @Override
    public Email addEmail(Email email) {
        return emailRepository.save(email);
    }

    @Override
>>>>>>> origin/main
    public List<Email> getAllEmail() {
        return emailRepository.findAll();
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> origin/main
    public Optional<Email> getEmailById(String emailId) {
        return emailRepository.findById(emailId);
    }

<<<<<<< HEAD
=======
    @Override
    public Email updateEmail(String emailId, Email emailDetails) {
        return emailRepository.findById(emailId).map(email -> {
            email.setToEmail(emailDetails.getToEmail());
            email.setSubject(emailDetails.getSubject());
            email.setBody(emailDetails.getBody());
            email.setStatus(emailDetails.getStatus());
            email.setDateAdded(emailDetails.getDateAdded());
            email.setTimeAdded(emailDetails.getTimeAdded());
            return emailRepository.save(email);
        }).orElseThrow(() -> new RuntimeException("Notification not found with id " + emailId));
    }

    @Override
>>>>>>> origin/main
    public void deleteEmail(String emailId) {
        emailRepository.deleteById(emailId);
    }
}
