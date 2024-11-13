package com.bkticketing.bkTicketing_backend.ServiceImplementation;
import com.bkticketing.bkTicketing_backend.Model.GeneralEvent;
import com.bkticketing.bkTicketing_backend.Repository.GeneralEventRepository;
import com.bkticketing.bkTicketing_backend.Service.GeneralEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
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
    @Override
    public List<GeneralEvent> getAllEvents() {
        List<GeneralEvent> events = eventRepository.findAll();
        for (GeneralEvent event : events) {
            String imagePath = event.getEventImagePath();
            
            if (imagePath != null && !imagePath.isEmpty()) {
                String fullPath = getAccessibleUrl("http://192.168.50.90:8080" + imagePath,
                "http://192.168.50.91:8080" + imagePath);
                event.setEventImagePath(fullPath);
            }
        }

        return events;
    }
    @Override
    public Optional<GeneralEvent> getEventById(String eventId) {
        return eventRepository.findById(eventId);
    }

    public List<GeneralEvent> getEventByType(String eventType) {
        List<GeneralEvent> events = eventRepository.findByType(eventType);
        for (GeneralEvent event : events) {
            String imagePath = event.getEventImagePath();

            if (imagePath != null && !imagePath.isEmpty()) {
                String fullPath = getAccessibleUrl("http://192.168.50.90:8080" + imagePath,
                                               "http://192.168.50.91:8080" + imagePath);
                event.setEventImagePath(fullPath);
            }
        }
        return events;
    }

    private String getAccessibleUrl(String... urls) {
        for (String url : urls) {
            if (isUrlAccessible(url)) {
                return url;
            }
        }
        return null; // or handle it if neither URL is accessible
    }
    private boolean isUrlAccessible(String urlString) {
    try {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        return (responseCode == HttpURLConnection.HTTP_OK);
    } catch (Exception e) {
        return false;
    }
}
    @Override
    public GeneralEvent addEvent(GeneralEvent event) {
        return eventRepository.save(event);
    }
    @Override
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
    @Override
    public void deleteEvent(String eventId) {
        eventRepository.deleteById(eventId);
    }
}
