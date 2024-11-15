package com.bkticketing.bkTicketing_backend.Controller;

import com.bkticketing.bkTicketing_backend.Service.RecordCountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/recordCount")
public class RecordCountController {
    private final RecordCountService recordCountService;

    public RecordCountController(RecordCountService recordCountService) {
        this.recordCountService = recordCountService;
    }

    @GetMapping("/generalEvents")
    public ResponseEntity<Long> getGeneralEventCount() {
        return ResponseEntity.ok(recordCountService.getGeneralEventCount());
    }

    @GetMapping("/theaters")
    public ResponseEntity<Long> getTheaterCount() {
        return ResponseEntity.ok(recordCountService.getTheaterCount());
    }

    @GetMapping("/sports")
    public ResponseEntity<Long> getSportCount() {
        return ResponseEntity.ok(recordCountService.getSportCount());
    }

    @GetMapping("/activity")
    public ResponseEntity<Long> getActivityCount() {
        return ResponseEntity.ok(recordCountService.getActivityCount());
    }

    @GetMapping("/notification")
    public ResponseEntity<Long> getNotificationCount() {
        return ResponseEntity.ok(recordCountService.getNotificationCount());
    }

    @GetMapping("/reservation")
    public ResponseEntity<Long> getReservationCount() {
        return ResponseEntity.ok(recordCountService.getReservationCount());
    }

    @GetMapping("/user")
    public ResponseEntity<Long> getUserCount() {
        return ResponseEntity.ok(recordCountService.getUserCounts());
    }
}
