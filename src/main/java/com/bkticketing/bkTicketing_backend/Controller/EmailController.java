package com.bkticketing.bkTicketing_backend.Controller;

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
