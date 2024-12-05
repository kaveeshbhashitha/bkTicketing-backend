package com.bkticketing.bkTicketing_backend.Service;
<<<<<<< HEAD

<<<<<<< HEAD
=======
import com.bkticketing.bkTicketing_backend.Model.Email;
import java.util.List;
import java.util.Optional;
>>>>>>> ecec8a2e23ab93e50b1e64e040841cce261c7984
import java.util.List;
import java.util.Optional;

import com.bkticketing.bkTicketing_backend.Model.Email;

public interface EmailService {
    String sendAndSaveEmail(String toEmail, String subject, String body);

    List<Email> getAllEmail();

    Optional<Email> getEmailById(String emailId);

<<<<<<< HEAD
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
=======
>>>>>>> ecec8a2e23ab93e50b1e64e040841cce261c7984
    void deleteEmail(String emailId);
}
