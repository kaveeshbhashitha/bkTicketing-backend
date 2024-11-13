package com.bkticketing.bkTicketing_backend.ServiceImplementation;
import com.bkticketing.bkTicketing_backend.Model.Theater;
import com.bkticketing.bkTicketing_backend.Repository.TheaterRepository;
import com.bkticketing.bkTicketing_backend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterServiceImplementation implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Override
    public List<Theater> getAllTheater() {
        List<Theater> events = theaterRepository.findAll();
        for (Theater event : events) {
            String imagePath = event.getTheaterImagePath();
            
            if (imagePath != null && !imagePath.isEmpty()) {
                String fullPath = getAccessibleUrl("http://192.168.50.90:8080" + imagePath,
                "http://192.168.50.91:8080" + imagePath);
                event.setTheaterImagePath(fullPath);
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
    public Optional<Theater> getTheaterById(String theaterId) {
        return theaterRepository.findById(theaterId);
    }

    @Override
    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
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

    @Override
    public void deleteTheater(String theaterId) {
        theaterRepository.deleteById(theaterId);
    }
}
