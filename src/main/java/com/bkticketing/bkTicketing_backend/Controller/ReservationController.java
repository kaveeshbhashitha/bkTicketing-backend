package com.bkticketing.bkTicketing_backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bkticketing.bkTicketing_backend.Model.Reservation;
import com.bkticketing.bkTicketing_backend.Service.ReservationService;

<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

>>>>>>> 8d7e22cc2d3bb23f1605dca04da2aa92ab5855f0
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/getAllReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/getReservationById/{id}")
    public Optional<Reservation> getReservationById(@PathVariable("id") String reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @GetMapping("/getReservationByUserId/{id}")
    public List<Reservation> getReservationByUserId(@PathVariable("id") String userId) {
        return reservationService.getReservationByUserId(userId);
    }

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation(@PathVariable("id") String reservationId,
            @RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservationId, reservation);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable("id") String reservationId) {
        reservationService.deleteReservation(reservationId);
        return "Match deleted with ID " + reservationId;
    }
}
