Ravun Voeut, [12/30/2025 10:47 PM]
package Lab06;

/**
 * Class: Subject
 * Description: Represents courses in Year 2 program with proper validation and coding standards.
 * Author: Voeut Ravon
 * Reviewer: Tann Sunlay
 * Date: 30-Dec-2025
 * Version: 1.0
 */

public class Subject {
    // IMPROVEMENT: Added MIN_CREDITS constant for better validation
    private static final int MAX_CREDITS = 4;
    private static final int MIN_CREDITS = 1;
    
    // IMPROVEMENT: Added getter for MIN_CREDITS for better encapsulation
    public static final int getMaxCredits() {
        return MAX_CREDITS;
    }
    public static final int getMinCredits() {
        return MIN_CREDITS;
    }
    
    // IMPROVEMENT: Added more descriptive instance variables
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String department;
    private int semester;
    private String instructor;
    private boolean isElective; // NEW: Added to make class more informative
    
    // Constructor - IMPROVEMENT: Added isElective parameter
    public Subject(String subjectCode, String subjectName, int credits, 
                   String department, int semester, String instructor, boolean isElective) {
        setSubjectCode(subjectCode);
        setName(subjectName);  // Uses validation from Task 3
        setCredits(credits);
        setDepartment(department); // IMPROVEMENT: Now uses setter with validation
        setSemester(semester);     // IMPROVEMENT: Now uses setter with validation
        setInstructor(instructor); // IMPROVEMENT: Now uses setter with validation
        this.isElective = isElective;
    }
    
    // Getters - IMPROVEMENT: Added isElective() getter
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
    
    public boolean isElective() {
        return isElective;
    }
    
    // Task 3: setName method with exception for empty/null
    // IMPROVEMENT: Added separate checks for null and empty with different messages
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Subject name cannot be null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty");
        }
        this.subjectName = name.trim();
    }
    
    // IMPROVEMENT: Added comprehensive validation for subject code format
    public void setSubjectCode(String code) {
        if (code == null  code.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject code cannot be null or empty");
        }
        // IMPROVEMENT: Added format validation (e.g., CS201, MAT101)
        if (!code.matches("[A-Za-z]{2,3}\\d{3}")) {
            throw new IllegalArgumentException("Subject code must be in format: ABC123");
        }
        this.subjectCode = code.toUpperCase(); // IMPROVEMENT: Standardize to uppercase
    }
    
    // IMPROVEMENT: Better error message with actual min/max values
    public void setCredits(int credits) {
        if (credits < MIN_CREDITS  credits > MAX_CREDITS) {
            throw new IllegalArgumentException(
                String.format("Credits must be between %d and %d", MIN_CREDITS, MAX_CREDITS)
            );
        }
        this.credits = credits;
    }
    
    // IMPROVEMENT: Added validation for department
    public void setDepartment(String department) {

Ravun Voeut, [12/30/2025 10:47 PM]
if (department == null  department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
        this.department = department.trim();
    }
    
    // IMPROVEMENT: Added validation for semester (1-8 typical range)
    public void setSemester(int semester) {
        if (semester < 1  semester > 8) {
            throw new IllegalArgumentException("Semester must be between 1 and 8");
        }
        this.semester = semester;
    }
    
    // IMPROVEMENT: Added validation for instructor
    public void setInstructor(String instructor) {
        if (instructor == null || instructor.trim().isEmpty()) {
            throw new IllegalArgumentException("Instructor cannot be null or empty");
        }
        this.instructor = instructor.trim();
    }
    
    // NEW: Setter for elective status
    public void setElective(boolean elective) {
        this.isElective = elective;
    }
    
    // IMPROVEMENT: Added utility method
    public boolean isAdvancedCourse() {
        return semester >= 5; // Typically advanced courses are in later semesters
    }
    
    // IMPROVEMENT: Better toString() with all fields
    @Override
    public String toString() {
        return String.format(
            "Subject[Code: %s, Name: %s, Credits: %d, Dept: %s, Semester: %d, Instructor: %s, Elective: %s]",
            subjectCode, subjectName, credits, department, semester, instructor, isElective
        );
    }
}