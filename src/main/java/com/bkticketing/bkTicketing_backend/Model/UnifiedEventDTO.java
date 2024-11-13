package com.bkticketing.bkTicketing_backend.Model;

public class UnifiedEventDTO {
    private String eventId;
    private String eventType;
    private String eventName;
    private String eventDate;

    public UnifiedEventDTO(String uniqueId, String eventType, String eventName, String eventDate) {
        this.eventId = uniqueId;
        this.eventType = eventType;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}
