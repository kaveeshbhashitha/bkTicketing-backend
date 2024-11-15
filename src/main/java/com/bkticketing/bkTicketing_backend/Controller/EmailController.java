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
    }
}
