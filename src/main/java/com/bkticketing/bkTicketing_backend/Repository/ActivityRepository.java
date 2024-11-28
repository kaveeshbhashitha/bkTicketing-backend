package com.bkticketing.bkTicketing_backend.Repository;
import com.bkticketing.bkTicketing_backend.Model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityRepository extends MongoRepository<Activity, String> {
}
