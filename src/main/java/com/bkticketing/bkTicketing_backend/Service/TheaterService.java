package com.bkticketing.bkTicketing_backend.Service;
import com.bkticketing.bkTicketing_backend.Model.Theater;
import java.util.List;
import java.util.Optional;
import java.util.List;
import java.util.Optional;

import com.bkticketing.bkTicketing_backend.Model.Theater;

public interface TheaterService {
    List<Theater> getAllTheater();

    Optional<Theater> getTheaterById(String theaterId);

    Theater addTheater(Theater theater);

    Theater updateTheater(String theaterId, Theater theaterDetails);

    void deleteTheater(String theaterId);
}
