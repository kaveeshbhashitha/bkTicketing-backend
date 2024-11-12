package com.bkticketing.bkTicketing_backend.Repository;

import com.bkticketing.bkTicketing_backend.Model.Sport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SportRepository extends MongoRepository<Sport, String> {
}
