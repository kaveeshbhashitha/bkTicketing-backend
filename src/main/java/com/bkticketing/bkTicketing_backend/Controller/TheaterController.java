package com.bkticketing.bkTicketing_backend.Controller;
import com.bkticketing.bkTicketing_backend.Model.Theater;
import com.bkticketing.bkTicketing_backend.Service.TheaterService;
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
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;
    private static final String IMAGE_DIRECTORY = "src/main/resources/static/images/";

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
