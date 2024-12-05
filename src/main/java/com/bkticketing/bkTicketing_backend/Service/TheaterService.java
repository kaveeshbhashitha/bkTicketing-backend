package com.bkticketing.bkTicketing_backend.Service;
<<<<<<< HEAD
<<<<<<< HEAD

=======
import com.bkticketing.bkTicketing_backend.Model.Theater;
import java.util.List;
import java.util.Optional;
>>>>>>> ecec8a2e23ab93e50b1e64e040841cce261c7984
import java.util.List;
import java.util.Optional;

import com.bkticketing.bkTicketing_backend.Model.Theater;

public interface TheaterService {
    List<Theater> getAllTheater();

    Optional<Theater> getTheaterById(String theaterId);

    Theater addTheater(Theater theater);

    Theater updateTheater(String theaterId, Theater theaterDetails);

<<<<<<< HEAD
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
=======
>>>>>>> ecec8a2e23ab93e50b1e64e040841cce261c7984
    void deleteTheater(String theaterId);
}
