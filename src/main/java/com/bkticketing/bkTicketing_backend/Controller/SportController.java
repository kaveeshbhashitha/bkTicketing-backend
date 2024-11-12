package com.bkticketing.bkTicketing_backend.Controller;

import com.bkticketing.bkTicketing_backend.Model.Sport;
import com.bkticketing.bkTicketing_backend.ServiceImplementation.SportServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private SportServiceImplementation sportServiceImplementation;

    @GetMapping("/getAllSport")
    public List<Sport> getAllSport() {
        return sportServiceImplementation.getAllSport();
    }

    @GetMapping("/getSportById/{id}")
    public Optional<Sport> getSportById(@PathVariable("id") String eventId) {
        return sportServiceImplementation.getSportById(eventId);
    }

    @PostMapping("/addSport")
    public Sport addMatch(@RequestBody Sport sport) {
        return sportServiceImplementation.addSport(sport);
    }

    @PutMapping("/updateSport/{id}")
    public Sport updateSport(@PathVariable("id") String eventId, @RequestBody Sport sport) {
        return sportServiceImplementation.updateSport(eventId, sport);
    }

    @DeleteMapping("/deleteSport/{id}")
    public String deleteSport(@PathVariable("id") String matchId) {
        sportServiceImplementation.deleteSport(matchId);
        return "Sport deleted with id " + matchId;
    }
}
