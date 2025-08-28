package dev.m3s.programming2.homework3;

import java.util.Calendar;

public class DesignatedCourse {
    private Course course;
    private boolean responsible = false;
    private int year; 

    public DesignatedCourse() {

    }

    public DesignatedCourse(Course course, boolean resp, int year) {
        this();
        setCourse(course);
        setResponsible(resp);
        setYear(year);
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        }
    } 

    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public boolean getResponsible() {
        return responsible;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if ((year >= 2000) && (year <= currentYear + 1)) {
            this.year = year;
        }
    }

    @Override
    public String toString() {
       return String.format("[course=%s, year=%d]", course.toString(), year); 
    }
}