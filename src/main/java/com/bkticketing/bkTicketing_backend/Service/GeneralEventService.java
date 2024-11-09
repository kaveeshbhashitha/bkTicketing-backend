package com.bkticketing.bkTicketing_backend.Service;

import com.bkticketing.bkTicketing_backend.Model.GeneralEvent;

import java.util.List;
import java.util.Optional;

public interface GeneralEventService {
    List<GeneralEvent> getAllEvents();
    Optional<GeneralEvent> getEventById(String eventId);
    GeneralEvent addEvent(GeneralEvent event);
    GeneralEvent updateEvent(String eventId, GeneralEvent eventDetails);
    void deleteEvent(String eventId);
}
