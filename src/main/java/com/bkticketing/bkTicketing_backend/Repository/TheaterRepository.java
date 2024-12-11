package com.bkticketing.bkTicketing_backend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bkticketing.bkTicketing_backend.Model.Theater;

public interface TheaterRepository extends MongoRepository<Theater, String> {
}
