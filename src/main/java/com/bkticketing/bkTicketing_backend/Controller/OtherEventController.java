package com.bkticketing.bkTicketing_backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkticketing.bkTicketing_backend.Model.OtherEvent;
import com.bkticketing.bkTicketing_backend.Service.OtherEventService;

@RestController
@CrossOrigin(origins={"http://localhost:3000","https://bkticketingfrontend.netlify.app"})
@RequestMapping("/otherEvent")
public class OtherEventController {
    @Autowired
    private OtherEventService otherEventService;

    @GetMapping("/getAllOtherEvents")
    public List<OtherEvent> getAllOtherEvents() {
        return otherEventService.getAllOtherEvents();
    }

    @GetMapping("/getOtherEventById/{id}")
    public Optional<OtherEvent> getOtherEventById(@PathVariable("id") String eventId) {
        return otherEventService.getOtherEventById(eventId);
    }

    @PostMapping("/addOtherEvent")
    public OtherEvent addOtherEvent(@RequestBody OtherEvent event) {
        return otherEventService.addOtherEvent(event);
    }

    @PutMapping("/updateOtherEvent/{id}")
    public OtherEvent updateOtherEvent(@PathVariable("id") String eventId, @RequestBody OtherEvent event) {
        return otherEventService.updateOtherEvent(eventId, event);
    }

    @DeleteMapping("/deleteOtherEvent/{id}")
    public String deleteOtherEvent(@PathVariable("id") String eventId) {
        otherEventService.deleteOtherEvent(eventId);
        return "Event deleted with id " + eventId;
    }
}
