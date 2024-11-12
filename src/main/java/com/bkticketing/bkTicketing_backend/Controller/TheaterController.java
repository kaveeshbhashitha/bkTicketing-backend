package com.bkticketing.bkTicketing_backend.Controller;

import com.bkticketing.bkTicketing_backend.Model.Theater;
import com.bkticketing.bkTicketing_backend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping("/getAllTheater")
    public List<Theater> getAllTheater() {
        return theaterService.getAllTheater();
    }

    @GetMapping("/getTheaterById/{id}")
    public Optional<Theater> getTheaterById(@PathVariable("id") String eventId) {
        return theaterService.getTheaterById(eventId);
    }

    @PostMapping("/addTheater")
    public Theater addTheater(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }

    @PutMapping("/updateTheater/{id}")
    public Theater updateTheater(@PathVariable("id") String theaterId, @RequestBody Theater theater) {
        return theaterService.updateTheater(theaterId, theater);
    }

    @DeleteMapping("/deleteTheater/{id}")
    public String deleteTheater(@PathVariable("id") String theaterId) {
        theaterService.deleteTheater(theaterId);
        return "Theater deleted with id " + theaterId;
    }
}
