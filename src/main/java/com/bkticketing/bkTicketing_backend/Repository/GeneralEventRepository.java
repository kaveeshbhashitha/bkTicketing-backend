package com.bkticketing.bkTicketing_backend.Repository;

import com.bkticketing.bkTicketing_backend.Model.GeneralEvent;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GeneralEventRepository extends MongoRepository<GeneralEvent, String> {
     @Query("{ 'eventType' : ?0 }")
    List<GeneralEvent> findByType(String eventType);

}
