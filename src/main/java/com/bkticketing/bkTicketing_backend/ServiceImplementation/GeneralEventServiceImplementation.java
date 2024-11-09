package com.bkticketing.bkTicketing_backend.ServiceImplementation;
import com.bkticketing.bkTicketing_backend.Model.GeneralEvent;
import com.bkticketing.bkTicketing_backend.Repository.GeneralEventRepository;
import com.bkticketing.bkTicketing_backend.Service.GeneralEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GeneralEventServiceImplementation implements GeneralEventService {
    @Autowired
    private GeneralEventRepository eventRepository;

    /*
    public List<GeneralEvent> getAllEvents() {
        return eventRepository.findAll();
    }
     */
    public List<GeneralEvent> getAllEvents() {
        List<GeneralEvent> events = eventRepository.findAll();
        for (GeneralEvent event : events) {
            String imagePath = event.getEventImagePath();
            
            if (imagePath != null && !imagePath.isEmpty()) {
                event.setEventImagePath("http://localhost:8080" + imagePath);
            }
        }

        return events;
    }

    public Optional<GeneralEvent> getEventById(String eventId) {
        return eventRepository.findById(eventId);
    }

    public GeneralEvent addEvent(GeneralEvent event) {
        return eventRepository.save(event);
    }

    public GeneralEvent updateEvent(String eventId, GeneralEvent eventDetails) {
        return eventRepository.findById(eventId).map(event -> {
            event.setEventName(eventDetails.getEventName());
            event.setEventDate(eventDetails.getEventDate());
            event.setEventTime(eventDetails.getEventTime());
            event.setEventVenue(eventDetails.getEventVenue());
            event.setEventOrganizer(eventDetails.getEventOrganizer());
            event.setOneTicketPrice(eventDetails.getOneTicketPrice());
            event.setDescription(eventDetails.getDescription());
            event.setEventType(eventDetails.getEventType());
            event.setEventIsFor(eventDetails.getEventIsFor());
            event.setNumOfTickets(eventDetails.getNumOfTickets());
            return eventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with id " + eventId));
    }

    public void deleteEvent(String eventId) {
        eventRepository.deleteById(eventId);
    }
}
