package Lab06;

/**
 * Class: Session
 * Description: Represents a study session of the day with duration validation.
 * Author: Voeut Ravon 
 * Reviewer: Tann Sunlay
 * Date: 30-Dec-2025
 * Version: 1.0
 */

public class Session {
    // Instance variables
    private String subjectCode;
    private int startTime;
    private int endTime;
    private String room;
    
    // Constructor
    public Session(String subjectCode, int startTime, int endTime, String room) {
        setSubjectCode(subjectCode);
        setDuration(startTime, endTime);  // Validates time
        setRoom(room);
    }
    
    // Getters
    public String getSubjectCode() {
        return subjectCode;
    }
    
    public int getStartTime() {
        return startTime;
    }
    
    public int getEndTime() {
        return endTime;
    }
    
    public String getRoom() {
        return room;
    }
    
    // Task 8: setDuration method with exception
    public void setDuration(int startTime, int endTime) {
        if (startTime >= endTime) {
            throw new IllegalArgumentException("Start time must be less than end time. Received: " 
                                               + startTime + " >= " + endTime);
        }
        if (startTime < 0 || startTime > 23 || endTime < 0 || endTime > 23) {
            throw new IllegalArgumentException("Times must be between 0 and 23 (24-hour format)");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }
    }
            throw new IllegalArgumentException("Room cannot be null or empty");
        }
        this.room = room.trim();
    }
    
    // Utility method to calculate duration
    public int getDuration() {
        return endTime - startTime;
    }
    
    @Override
    public String toString() {
        return String.format("Session[Subject: %s, Time: %02d:00-%02d:00, Room: %s, Duration: %d hour(s)]",
                subjectCode, startTime, endTime, room, getDuration());
    }
}    
    public void setRoom(String room) {
        if (room == null || room.trim().isEmpty()) {
    
        }
        this.subjectCode = subjectCode.trim().toUpperCase();
    // Additional setters with validation
    public void setSubjectCode(String subjectCode) {
        if (subjectCode == null || subjectCode.trim().isEmpty()) {
