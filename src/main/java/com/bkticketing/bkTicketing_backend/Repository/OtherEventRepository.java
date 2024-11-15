package com.bkticketing.bkTicketing_backend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bkticketing.bkTicketing_backend.Model.OtherEvent;

public interface OtherEventRepository extends MongoRepository<OtherEvent, String> {

}
