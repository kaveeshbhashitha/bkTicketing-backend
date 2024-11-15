package com.bkticketing.bkTicketing_backend.Controller;
import com.bkticketing.bkTicketing_backend.Model.GeneralEvent;
import com.bkticketing.bkTicketing_backend.ServiceImplementation.GeneralEventServiceImplementation;
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
@CrossOrigin("http://localhost:3000")
@RequestMapping("/generalEvent")
public class GeneralEventController {
    @Autowired
    private GeneralEventServiceImplementation eventService;

    private static final String IMAGE_DIRECTORY = "src/main/resources/static/images/";

    @GetMapping("/getAllEvents")
    public List<GeneralEvent> getAllEvents() {
        return eventService.getAllEvents();
    }
    

    @GetMapping("/getEventById/{id}")
    public Optional<GeneralEvent> getEventById(@PathVariable("id") String eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping("/getEventByType/{eventType}")
    public List<GeneralEvent> getEventByType(@PathVariable("eventType") String eventType) {
        return eventService.getEventByType(eventType);
    }



    @PostMapping("/addEvent")
    public GeneralEvent addEvent(@RequestBody GeneralEvent event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/updateEvent/{id}")
    public GeneralEvent updateEvent(@PathVariable("id") String eventId, @RequestBody GeneralEvent event) {
        return eventService.updateEvent(eventId, event);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable("id") String eventId) {
        eventService.deleteEvent(eventId);
        return "Event deleted with id " + eventId;
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
