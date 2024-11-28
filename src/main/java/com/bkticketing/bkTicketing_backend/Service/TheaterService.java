package com.bkticketing.bkTicketing_backend.Service;
<<<<<<< HEAD

import java.util.List;
import java.util.Optional;

import com.bkticketing.bkTicketing_backend.Model.Theater;

public interface TheaterService {
    List<Theater> getAllTheater();

    Optional<Theater> getTheaterById(String theaterId);

    Theater addTheater(Theater theater);

    Theater updateTheater(String theaterId, Theater theaterDetails);

=======
import com.bkticketing.bkTicketing_backend.Model.Theater;
import java.util.List;
import java.util.Optional;

public interface TheaterService {
    List<Theater> getAllTheater();
    Optional<Theater> getTheaterById(String theaterId);
    Theater addTheater(Theater theater);
    Theater updateTheater(String theaterId, Theater theaterDetails);
>>>>>>> origin/main
    void deleteTheater(String theaterId);
}
