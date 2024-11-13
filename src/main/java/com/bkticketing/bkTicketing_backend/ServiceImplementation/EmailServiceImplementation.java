package com.bkticketing.bkTicketing_backend.ServiceImplementation;
import com.bkticketing.bkTicketing_backend.Model.Email;
import com.bkticketing.bkTicketing_backend.Repository.EmailRepository;
import com.bkticketing.bkTicketing_backend.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImplementation implements EmailService {
    @Autowired
    private EmailRepository emailRepository;
    @Override
    public Email addEmail(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public List<Email> getAllEmail() {
        return emailRepository.findAll();
    }

    @Override
    public Optional<Email> getEmailById(String emailId) {
        return emailRepository.findById(emailId);
    }

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
    public void deleteEmail(String emailId) {
        emailRepository.deleteById(emailId);
    }
}
