package com.bkticketing.bkTicketing_backend.Service;
import com.bkticketing.bkTicketing_backend.Model.Email;
import java.util.List;
import java.util.Optional;
import java.util.List;
import java.util.Optional;

import com.bkticketing.bkTicketing_backend.Model.Email;

public interface EmailService {
    String sendAndSaveEmail(String toEmail, String subject, String body);

    List<Email> getAllEmail();

    Optional<Email> getEmailById(String emailId);

    Email updateEmail(String emailId, Email emailDetails);

    void deleteEmail(String emailId);

    Email addEmail(Email email);
}
