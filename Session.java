Ravun Voeut, [12/30/2025 10:51 PM]
package Lab06;

/**
 * Class: Session
 * Description: Represents a study session of the day with duration validation and coding standards.
 * Author: Voeut Ravon
 * Reviewer: Tann Sunlay
 * Date: 30-Dec-2025
 * Version: 1.0
 */

public class Session {
    // IMPROVEMENT: Added constants for better maintainability
    private static final int MIN_HOUR = 0;
    private static final int MAX_HOUR = 23;
    
    // IMPROVEMENT: Added dayOfWeek field for more complete session representation
    private String subjectCode;
    private int startTime;
    private int endTime;
    private String room;
    private String dayOfWeek; // NEW: Added to make session more informative
    
    // Constructor - IMPROVEMENT: Added dayOfWeek parameter
    public Session(String subjectCode, int startTime, int endTime, String room, String dayOfWeek) {
        setSubjectCode(subjectCode);
        setDuration(startTime, endTime);  // Validates using Task 8 requirements
        setRoom(room);
        setDayOfWeek(dayOfWeek); // IMPROVEMENT: Now validates day of week
    }
    
    // Getters - IMPROVEMENT: Added getDayOfWeek()
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
    
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    
    // Task 8: setDuration method with exception for invalid times
    // IMPROVEMENT: Added comprehensive time validation (0-23 range)
    public void setDuration(int startTime, int endTime) {
        // IMPROVEMENT: Validate hour range first
        if (startTime < MIN_HOUR  startTime > MAX_HOUR  
            endTime < MIN_HOUR  endTime > MAX_HOUR) {
            throw new IllegalArgumentException(
                String.format("Times must be between %d and %d (24-hour format)", MIN_HOUR, MAX_HOUR)
            );
        }
        
        // Task 8 requirement: startTime must be less than endTime
        if (startTime >= endTime) {
            throw new IllegalArgumentException(
                String.format("Start time (%d) must be less than end time (%d)", startTime, endTime)
            );
        }
        
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    // IMPROVEMENT: Added validation for subject code
    public void setSubjectCode(String subjectCode) {
        if (subjectCode == null  subjectCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject code cannot be null or empty");
        }
        this.subjectCode = subjectCode.trim().toUpperCase(); // Standardize format
    }
    
    // IMPROVEMENT: Added validation for room
    public void setRoom(String room) {
        if (room == null  room.trim().isEmpty()) {
            throw new IllegalArgumentException("Room cannot be null or empty");
        }
        this.room = room.trim();
    }
    
    // IMPROVEMENT: Added comprehensive day of week validation
    public void setDayOfWeek(String dayOfWeek) {
        if (dayOfWeek == null  dayOfWeek.trim().isEmpty()) {
            throw new IllegalArgumentException("Day of week cannot be null or empty");
        }
        
        String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String inputDay = dayOfWeek.trim();
        boolean isValid = false;
        
        // IMPROVEMENT: Case-insensitive comparison
        for (String day : validDays) {
            if (day.equalsIgnoreCase(inputDay)) {
                this.dayOfWeek = day;  // Standardize capitalization
                isValid = true;
                break;
            }
        }
        
        if (!isValid) {
            throw new IllegalArgumentException("Invalid day of week: " + inputDay);
        }
    }
    
    // IMPROVEMENT: Added utility methods for better functionality
    
    public int getDuration() {
        return endTime - startTime;
    }
    
    public boolean isMorningSession() {

Ravun Voeut, [12/30/2025 10:51 PM]
return endTime <= 12; // Session ends by noon
    }
    
    public boolean isAfternoonSession() {
        return startTime >= 12; // Session starts at noon or later
    }
    
    // IMPROVEMENT: Added method to check session overlaps
    public boolean overlapsWith(Session other) {
        return !(this.endTime <= other.startTime || this.startTime >= other.endTime);
    }
    
    // IMPROVEMENT: Better toString() with day of week
    @Override
    public String toString() {
        return String.format(
            "Session[Subject: %s, Day: %s, Time: %02d:00-%02d:00, Room: %s, Duration: %d hour(s)]",
            subjectCode, dayOfWeek, startTime, endTime, room, getDuration()
        );
    }
}