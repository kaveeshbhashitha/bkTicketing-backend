package com.bkticketing.bkTicketing_backend.Service;

import java.util.List;
import java.util.Optional;

import com.bkticketing.bkTicketing_backend.Model.Reservation;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(String reservationId);
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(String reservationId, Reservation reservationDetail);
    void deleteReservation(String reservationId);
}
