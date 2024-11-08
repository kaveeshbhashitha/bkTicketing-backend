package com.bkticketing.bkTicketing_backend.Repository;
import com.bkticketing.bkTicketing_backend.Model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepository extends MongoRepository<Email, String> {
}
