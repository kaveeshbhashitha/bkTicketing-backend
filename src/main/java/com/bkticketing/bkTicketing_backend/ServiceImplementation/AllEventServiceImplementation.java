package com.bkticketing.bkTicketing_backend.ServiceImplementation;

import com.bkticketing.bkTicketing_backend.Model.GeneralEvent;
import com.bkticketing.bkTicketing_backend.Model.Sport;
import com.bkticketing.bkTicketing_backend.Model.Theater;
import com.bkticketing.bkTicketing_backend.Model.UnifiedEventDTO;
import com.bkticketing.bkTicketing_backend.Repository.GeneralEventRepository;
import com.bkticketing.bkTicketing_backend.Repository.SportRepository;
import com.bkticketing.bkTicketing_backend.Repository.TheaterRepository;
import com.bkticketing.bkTicketing_backend.Service.AllEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllEventServiceImplementation implements AllEventService {
    @Autowired
    private GeneralEventRepository generalEventRepository;
    @Autowired
    private SportRepository sportRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Override
    public List<UnifiedEventDTO> getAllEvents() {
        List<UnifiedEventDTO> unifiedEvents = new ArrayList<>();

        for (GeneralEvent event : generalEventRepository.findAll()) {
            UnifiedEventDTO dto = new UnifiedEventDTO(
                    "gen-" + event.getEventId(),
                    "generalEvent",
                    event.getEventName(),
                    event.getEventDate()
            );
            unifiedEvents.add(dto);
        }

        for (Sport sport : sportRepository.findAll()) {
            UnifiedEventDTO dto = new UnifiedEventDTO(
                    "sport-" + sport.getEventId(),
                    "sport",
                    sport.getEventName(),
                    sport.getMatchDate()
            );
            unifiedEvents.add(dto);
        }

        for (Theater theater : theaterRepository.findAll()) {
            UnifiedEventDTO dto = new UnifiedEventDTO(
                    "theater-" + theater.getEventId(),
                    "theater",
                    theater.getEventName(),
                    theater.getTheaterDate()
            );
            unifiedEvents.add(dto);
        }
        return unifiedEvents;
    }
}
