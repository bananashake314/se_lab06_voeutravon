package Lab06;

/**
 * Class: Subject
 * Description: Represents courses in Year 2 program with proper validation.
 * Author: Voeut Ravon 
 * Reviewer: Tann Sunlay
 * Date: 30-Dec-2025
 * Version: 1.0
 */

public class Subject {
    // Constants (allowed global variables as per Task 1)
    private static final int MAX_CREDITS = 4;
    public static final int getMaxCredits() {
        return MAX_CREDITS;
    }
    
    // Private instance variables (not global)
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String department;
    private int semester;
    private String instructor;
    
    // Constructor
    public Subject(String subjectCode, String subjectName, int credits, 
                   String department, int semester, String instructor) {
        setSubjectCode(subjectCode);
        setName(subjectName);  // Using setName for validation
        setCredits(credits);
        this.department = department;
        this.semester = semester;
        this.instructor = instructor;
    }
    
    // Getters
    public String getSubjectCode() {
        return subjectCode;
    }
    
    public String getSubjectName() {
        return subjectName;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public int getSemester() {
        return semester;
    }
    
    public String getInstructor() {
        return instructor;
    }
    
    // Task 3: setName method with exception handling
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty");
        }
        this.subjectName = name.trim();
    }
    
    // Additional setter with validation
    public void setSubjectCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject code cannot be null or empty");
        }
        this.subjectCode = code.trim().toUpperCase();
    }
    
    public void setCredits(int credits) {
        if (credits <= 0 || credits > MAX_CREDITS) {
            throw new IllegalArgumentException("Credits must be between 1 and " + MAX_CREDITS);
        }
        this.credits = credits;
    }
    
    // Additional setters
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
    @Override
    public String toString() {
        return String.format("Subject[Code: %s, Name: %s, Credits: %d, Dept: %s, Semester: %d, Instructor: %s]",
                subjectCode, subjectName, credits, department, semester, instructor);
    }
}
