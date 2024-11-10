package com.bkticketing.bkTicketing_backend.Repository;

import com.bkticketing.bkTicketing_backend.Model.GeneralEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeneralEventRepository extends MongoRepository<GeneralEvent, String> {

}
