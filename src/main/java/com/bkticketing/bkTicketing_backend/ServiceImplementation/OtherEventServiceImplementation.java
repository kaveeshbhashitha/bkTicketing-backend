package com.bkticketing.bkTicketing_backend.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bkticketing.bkTicketing_backend.Model.OtherEvent;
import com.bkticketing.bkTicketing_backend.Repository.OtherEventRepository;
import com.bkticketing.bkTicketing_backend.Service.OtherEventService;

public class OtherEventServiceImplementation implements OtherEventService {
    @Autowired
    private OtherEventRepository otherEventRepository;

    public List<OtherEvent> getAllOtherEvents() {
        return otherEventRepository.findAll();
    }

    public Optional<OtherEvent> getOtherEventById(String eventId) {
        return otherEventRepository.findById(eventId);
    }

    public OtherEvent addOtherEvent(OtherEvent otherEvent) {
        return otherEventRepository.save(otherEvent);
    }

    public OtherEvent updateOtherEvent(String otherEventId, OtherEvent otherEventDetails) {
        return otherEventRepository.findById(otherEventId).map(event -> {
            event.setEventName(otherEventDetails.getEventName());
            event.setEventDate(otherEventDetails.getEventDate());
            event.setEventTime(otherEventDetails.getEventTime());
            event.setEventVenue(otherEventDetails.getEventVenue());
            event.setEventOrganizer(otherEventDetails.getEventOrganizer());
            event.setOneTicketPrice(otherEventDetails.getOneTicketPrice());
            event.setDescription(otherEventDetails.getDescription());
            event.setEventType(otherEventDetails.getEventType());
            event.setEventIsFor(otherEventDetails.getEventIsFor());
            event.setNumOfTickets(otherEventDetails.getNumOfTickets());
            return otherEventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with id " + otherEventId));
    }

    public void deleteOtherEvent(String eventId) {
        otherEventRepository.deleteById(eventId);
    }

}
