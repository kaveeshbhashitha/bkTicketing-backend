package com.bkticketing.bkTicketing_backend.ServiceImplementation;
import com.bkticketing.bkTicketing_backend.Model.Sport;
import com.bkticketing.bkTicketing_backend.Repository.SportRepository;
import com.bkticketing.bkTicketing_backend.Service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImplementation implements SportService {
    @Autowired
    private SportRepository sportRepository;
    @Override
    public List<Sport> getAllSport() {
       List<Sport> events = sportRepository.findAll();
        for (Sport event : events) {
            String imagePath = event.getMatchImagePath();
            
            if (imagePath != null && !imagePath.isEmpty()) {
                String fullPath = getAccessibleUrl("http://localhost:8080" + imagePath);
                event.setMatchImagePath(fullPath);
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
    public Optional<Sport> getSportById(String eventId) {
        return sportRepository.findById(eventId);
    }

    @Override
    public Sport addSport(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public Sport updateSport(String eventId, Sport sportDetails) {
        return sportRepository.findById(eventId).map(match -> {
            match.setEventName(sportDetails.getEventName());
            match.setMatchDate(sportDetails.getMatchDate());
            match.setMatchTime(sportDetails.getMatchTime());
            match.setMatchVenue(sportDetails.getMatchVenue());
            match.setMatchHost(sportDetails.getMatchHost());
            match.setOneTicketPrice(sportDetails.getOneTicketPrice());
            match.setTeamOne(sportDetails.getTeamOne());
            match.setTeamTwo(sportDetails.getTeamTwo());
            match.setMatchType(sportDetails.getMatchType()); // Removed the duplicate line
            match.setNumOfTickets(sportDetails.getNumOfTickets());
            return sportRepository.save(match);
        }).orElseThrow(() -> new RuntimeException("Sport not found with id " + eventId));
    }

    @Override
    public void deleteSport(String eventId) {
        sportRepository.deleteById(eventId);
    }
}
