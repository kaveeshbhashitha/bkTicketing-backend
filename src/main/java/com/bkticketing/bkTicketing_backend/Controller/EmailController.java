<<<<<<< HEAD
=======
package com.bkticketing.bkTicketing_backend.Controller;
import com.bkticketing.bkTicketing_backend.Model.Email;
import com.bkticketing.bkTicketing_backend.ServiceImplementation.EmailServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/notification")
public class EmailController {
    @Autowired
    private EmailServiceImplementation emailServiceImplementation;

    @GetMapping("/getAllNotification")
    public List<Email> getAllEmail() {
        return emailServiceImplementation.getAllEmail();
    }

    @GetMapping("/getNotificationById/{id}")
    public Optional<Email> getEmailById(@PathVariable("id") String emailId) {
        return emailServiceImplementation.getEmailById(emailId);
    }

    @PostMapping("/addNotification")
    public Email addEmail(@RequestBody Email email) {
        return emailServiceImplementation.addEmail(email);
    }

    @PutMapping("/updateNotification/{id}")
    public Email updateEmail(@PathVariable("id") String emailId, @RequestBody Email email) {
        return emailServiceImplementation.updateEmail(emailId, email);
    }

    @DeleteMapping("/deleteNotification/{id}")
    public String deleteEmail(@PathVariable("id") String emailId) {
        emailServiceImplementation.deleteEmail(emailId);
        return "Notification deleted with id " + emailId;
=======
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkticketing.bkTicketing_backend.Model.Email;
import com.bkticketing.bkTicketing_backend.Service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody Email emailRequest) {
        String result = emailService.sendAndSaveEmail(emailRequest.getToEmail(),
                emailRequest.getSubject(),
                emailRequest.getBody());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllEmail")
    public List<Email> getAllEmail() {
        return emailService.getAllEmail();
    }

    @GetMapping("/getEmailById/{id}")
    public Optional<Email> getEmailById(@PathVariable("id") String emailId) {
        return emailService.getEmailById(emailId);
    }

    @DeleteMapping("/deleteEmail/{id}")
    public String deleteEmail(@PathVariable("id") String emailId) {
        emailService.deleteEmail(emailId);
        return "Email deleted with id " + emailId;
    }
}
>>>>>>> ecec8a2e23ab93e50b1e64e040841cce261c7984
