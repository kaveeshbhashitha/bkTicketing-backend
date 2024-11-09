package com.bkticketing.bkTicketing_backend.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkticketing.bkTicketing_backend.Model.Reservation;
import com.bkticketing.bkTicketing_backend.Repository.ReservationRepository;
import com.bkticketing.bkTicketing_backend.Service.ReservationService;

@Service
public class ReservationServiceImplementation implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(String reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(String reservationId, Reservation reservationDetail) {
        return reservationRepository.findById(reservationId).map(reservation -> {
            reservation.setEventId(reservationDetail.getEventId());
            reservation.setUserId(reservationDetail.getUserId());
            reservation.setReservationDate(reservationDetail.getReservationDate());
            reservation.setReservationTime(reservationDetail.getReservationTime());
            reservation.setNumOfTickets(reservationDetail.getNumOfTickets());
            reservation.setPerTicketCharge(reservationDetail.getPerTicketCharge());
            reservation.setStatus(reservationDetail.getStatus());
            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new RuntimeException("Reservation not found with id " + reservationId));
    }

    public void deleteReservation(String reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
