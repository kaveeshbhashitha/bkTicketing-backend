package com.bkticketing.bkTicketing_backend.Controller;
import com.bkticketing.bkTicketing_backend.Model.UnifiedEventDTO;
import com.bkticketing.bkTicketing_backend.ServiceImplementation.AllEventServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/unifiedEvent")
public class UnifiedEventController {
    @Autowired
    private AllEventServiceImplementation allEventServiceImplementation;

    @GetMapping("/getAllUnifiedEvents")
    public List<UnifiedEventDTO> getAllEvents() {
        return allEventServiceImplementation.getAllEvents();
    }
}
