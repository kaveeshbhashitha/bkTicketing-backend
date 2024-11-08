package com.bkticketing.bkTicketing_backend.Repository;
import com.bkticketing.bkTicketing_backend.Model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

}
