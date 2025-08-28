package dev.m3s.programming2.homework3;

import java.util.Calendar;

public class StudentCourse {
    private Course course; 
    private int gradeNum;
    private int yearCompleted = 0;

    public StudentCourse() {

    }

    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setYear(yearCompleted);
        setGrade(gradeNum);
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        return this.gradeNum;
    }

    private boolean checkGradeValidity(final int gradeNum, boolean isNumbericGrading) {

        if (isNumbericGrading) {
            return gradeNum >= 0 && gradeNum <= 5;
        } else {
            return (gradeNum >= 'A' && gradeNum <= 'F') || (gradeNum >= 'a' && gradeNum <= 'f');
        }
    }

    protected void setGrade(int gradeNum) {
        if (course == null) {
            return;
        }
        boolean isNumbericGrading = course.isNumericGrade();
        if (checkGradeValidity(gradeNum, isNumbericGrading)) {
            this.gradeNum = gradeNum;
            if (yearCompleted == 0) {
                this.yearCompleted = Calendar.getInstance().get(Calendar.YEAR);
            }
        }
    }
    

    public boolean isPassed() {
        boolean isNumeric = course.isNumericGrade();
        if (isNumeric) {
            return gradeNum >= 1 && gradeNum <= 5;
        } 
        else {
            // Only 'A' to 'E' are passing grades
            return gradeNum == 'A' || gradeNum == 'B' || gradeNum == 'C' ||
                   gradeNum == 'D' || gradeNum == 'E' ||
                   gradeNum == 'a' || gradeNum == 'b' || gradeNum == 'c' ||
                   gradeNum == 'd' || gradeNum == 'e';
        }
    }
    

    public int getYear() {
        return this.yearCompleted;
    }

    public void setYear(final int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year > 2000 && year < currentYear) {
            this.yearCompleted = year; 
        }
    }

    @Override
    public String toString() {
    String gradeString; 
    String courseInfo = course.toString();  // get course information from course.toString()

    if (gradeNum == 0) {
        gradeString = "\"Not graded\"";
    } else if (gradeNum >= 1 && gradeNum <= 5) {
        gradeString = Integer.toString(gradeNum);
    } else {
        gradeString = Character.toString((char) gradeNum);
    }

    // Ensure that spaces and punctuation match the expected format exactly.
    return String.format("%s Year: %d, Grade: %s.]", courseInfo, yearCompleted, gradeString);
}

}
