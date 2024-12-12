package com.bkticketing.bkTicketing_backend.Service;

import java.util.List;
import java.util.Optional;

import com.bkticketing.bkTicketing_backend.Model.OtherEvent;

public interface OtherEventService {
    List<OtherEvent> getAllOtherEvents();

    Optional<OtherEvent> getOtherEventById(String eventId);

    OtherEvent addOtherEvent(OtherEvent otherEvent);

    OtherEvent updateOtherEvent(String otherEventId, OtherEvent otherEventDetails);

    void deleteOtherEvent(String eventId);
}
