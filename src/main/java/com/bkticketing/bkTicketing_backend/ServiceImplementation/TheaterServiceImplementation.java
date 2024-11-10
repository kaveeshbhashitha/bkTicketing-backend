package com.bkticketing.bkTicketing_backend.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkticketing.bkTicketing_backend.Model.Theater;
import com.bkticketing.bkTicketing_backend.Repository.TheaterRepository;
import com.bkticketing.bkTicketing_backend.Service.TheaterService;

@Service
public class TheaterServiceImplementation implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getAllTheater() {
        return theaterRepository.findAll();
    }

    public Optional<Theater> getTheaterById(String theaterId) {
        return theaterRepository.findById(theaterId);
    }

    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public Theater updateTheater(String theaterId, Theater theaterDetails) {
        return theaterRepository.findById(theaterId).map(theater -> {
            theater.setEventName(theaterDetails.getEventName());
            theater.setTheaterDate(theaterDetails.getTheaterDate());
            theater.setTheaterTime1(theaterDetails.getTheaterTime1());
            theater.setTheaterTime2(theaterDetails.getTheaterTime2());
            theater.setTheaterVenue(theaterDetails.getTheaterVenue());
            theater.setTheaterOrganizer(theaterDetails.getTheaterOrganizer());
            theater.setDescription(theaterDetails.getDescription());
            theater.setOneTicketPrice(theaterDetails.getOneTicketPrice());
            theater.setTheaterImagePath(theaterDetails.getTheaterImagePath());
            theater.setTheaterIsFor(theaterDetails.getTheaterIsFor());
            theater.setNumOfTickets(theaterDetails.getNumOfTickets());
            return theaterRepository.save(theater);
        }).orElseThrow(() -> new RuntimeException("Theater not found with id " + theaterId));
    }

    public void deleteTheater(String theaterId) {
        theaterRepository.deleteById(theaterId);
    }

}
