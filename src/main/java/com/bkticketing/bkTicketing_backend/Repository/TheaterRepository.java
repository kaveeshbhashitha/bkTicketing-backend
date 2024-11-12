package com.bkticketing.bkTicketing_backend.Repository;

import com.bkticketing.bkTicketing_backend.Model.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TheaterRepository extends MongoRepository<Theater, String> {
}
