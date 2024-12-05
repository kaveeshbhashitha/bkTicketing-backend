package com.bkticketing.bkTicketing_backend.Model;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
>>>>>>> origin/main

import java.time.LocalDate;
import java.time.LocalTime;

<<<<<<< HEAD
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

=======
>>>>>>> origin/main
=======
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

>>>>>>> ecec8a2e23ab93e50b1e64e040841cce261c7984
@Document(collection = "theater")
public class Theater {
    @Id
    private String eventId;
    private String eventName;
    private String theaterDate;
    private String theaterTime1;
    private String theaterTime2;
    private String theaterVenue;
    private String theaterOrganizer;
    private String description;
    private Double oneTicketPrice;
    private String theaterIsFor;
    private String theaterImagePath;
    private Integer numOfTickets;
    private LocalDate dateAdded = LocalDate.now();
    private LocalTime timeAdded = LocalTime.now();

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTheaterDate() {
        return theaterDate;
    }

    public void setTheaterDate(String theaterDate) {
        this.theaterDate = theaterDate;
    }

    public String getTheaterTime1() {
        return theaterTime1;
    }

    public void setTheaterTime1(String theaterTime1) {
        this.theaterTime1 = theaterTime1;
    }

    public String getTheaterTime2() {
        return theaterTime2;
    }

    public void setTheaterTime2(String theaterTime2) {
        this.theaterTime2 = theaterTime2;
    }

    public String getTheaterVenue() {
        return theaterVenue;
    }

    public void setTheaterVenue(String theaterVenue) {
        this.theaterVenue = theaterVenue;
    }

    public String getTheaterOrganizer() {
        return theaterOrganizer;
    }

    public void setTheaterOrganizer(String theaterOrganizer) {
        this.theaterOrganizer = theaterOrganizer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getOneTicketPrice() {
        return oneTicketPrice;
    }

    public void setOneTicketPrice(Double oneTicketPrice) {
        this.oneTicketPrice = oneTicketPrice;
    }

    public String getTheaterIsFor() {
        return theaterIsFor;
    }

    public void setTheaterIsFor(String theaterIsFor) {
        this.theaterIsFor = theaterIsFor;
    }

    public String getTheaterImagePath() {
        return theaterImagePath;
    }

    public void setTheaterImagePath(String theaterImagePath) {
        this.theaterImagePath = theaterImagePath;
    }

    public Integer getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(Integer numOfTickets) {
        this.numOfTickets = numOfTickets;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalTime timeAdded) {
        this.timeAdded = timeAdded;
    }
}
