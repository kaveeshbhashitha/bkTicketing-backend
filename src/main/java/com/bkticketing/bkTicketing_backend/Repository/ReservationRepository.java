package com.bkticketing.bkTicketing_backend.Repository;
import com.bkticketing.bkTicketing_backend.Model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    List<Reservation> findReservationByUserId(String userId);
}
