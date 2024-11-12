package com.bkticketing.bkTicketing_backend.Service;
import com.bkticketing.bkTicketing_backend.Model.UnifiedEventDTO;
import java.util.List;

public interface AllEventService {
    public List<UnifiedEventDTO> getAllEvents();
}
