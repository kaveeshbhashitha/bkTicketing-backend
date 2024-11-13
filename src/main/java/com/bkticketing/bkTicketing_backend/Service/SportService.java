package com.bkticketing.bkTicketing_backend.Service;
import com.bkticketing.bkTicketing_backend.Model.Sport;
import java.util.List;
import java.util.Optional;

public interface SportService {
    List<Sport> getAllSport();
    Optional<Sport> getSportById(String eventId);
    Sport addSport(Sport sport);
    Sport updateSport(String eventId, Sport sportDetails);
    void deleteSport(String eventId);
}
