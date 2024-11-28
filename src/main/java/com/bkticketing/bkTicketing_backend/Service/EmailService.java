package com.bkticketing.bkTicketing_backend.Service;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import com.bkticketing.bkTicketing_backend.Model.Email;

public interface EmailService {
    String sendAndSaveEmail(String toEmail, String subject, String body);

    List<Email> getAllEmail();

    Optional<Email> getEmailById(String emailId);

=======
import com.bkticketing.bkTicketing_backend.Model.Email;

import java.util.List;
import java.util.Optional;
public interface EmailService {
    Email addEmail(Email email);
    List<Email> getAllEmail();
    Optional<Email> getEmailById(String emailId);
    Email updateEmail(String emailId, Email emailDetails);
>>>>>>> origin/main
    void deleteEmail(String emailId);
}
