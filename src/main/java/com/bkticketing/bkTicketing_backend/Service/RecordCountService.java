package com.bkticketing.bkTicketing_backend.Service;

public interface RecordCountService {
    long getGeneralEventCount();
    long getTheaterCount();
    long getSportCount();
    long getReservationCount();
    long getNotificationCount();
    long getUserCounts();
    long getActivityCount();
}
