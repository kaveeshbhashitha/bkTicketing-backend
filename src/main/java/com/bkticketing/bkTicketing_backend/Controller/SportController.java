package com.bkticketing.bkTicketing_backend.Controller;

import com.bkticketing.bkTicketing_backend.Model.Sport;
import com.bkticketing.bkTicketing_backend.ServiceImplementation.SportServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private SportServiceImplementation sportServiceImplementation;

    private static final String IMAGE_DIRECTORY = "src/main/resources/static/images/";


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

     @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(IMAGE_DIRECTORY, filename);

            Files.createDirectories(filePath.getParent());

            Files.write(filePath, file.getBytes());

            return ResponseEntity.ok("/images/" + filename);

        } catch (IOException e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }
}
