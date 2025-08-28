package dev.m3s.programming2.homework3;

public class Course {
    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private Character courseBase = ' ';
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;

    public Course() {

    }

    public Course(String name, final int code, Character courseBase, 
                final int type, final int period, final double credits, boolean numericGrade) {
                    setName(name);
                    setCourseCode(code, courseBase);
                    setCourseType(type);
                    setPeriod(period);
                    setCredits(credits);
                    setNumericGrade(numericGrade);
                }
    

    public Course(Course other) {
        if (other != null) {
            this.name = other.name;
            this.courseCode = other.courseCode;
            this.courseBase = other.courseBase;
            this.courseType = other.courseType;
            this.period = other.period;
            this.credits = other.credits;
            this.numericGrade = other.numericGrade;
        }
    }

    public String getName() {
        return this.name;
    } 
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getCourseTypeString() {
        if (courseType == ConstantValues.MANDATORY) {
            return "Mandatory";
        } else if (courseType == ConstantValues.OPTIONAL) {
            return "Optional";
        } else {
            return "Unknown";
        }
    }

    public int getCourseType() {
        return this.courseType;
    }

    public void setCourseType(final int type) {
        if (type == ConstantValues.MANDATORY || type == ConstantValues.OPTIONAL || type == ConstantValues.ALL) {
            this.courseType= type;
        } 
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public Character getCourseBase() {
        return this.courseBase;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {
        if (courseBase != null) {
            courseBase = Character.toUpperCase(courseBase); // Convert to uppercase
        }
        if ((courseCode > 0 && courseCode < 1000000) 
        && (courseBase == 'A' || courseBase == 'P' || courseBase == 'S')) {
            String courseCodeString = Integer.toString(courseCode); 
            this.courseCode = courseCodeString + courseBase;
            this.courseBase = courseBase;
        }
    }

    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(final int period) {
        if (period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD) {
            this.period = period; 
        }
    }

    public double getCredits() {
        return this.credits;
    }

    private void setCredits(final double credits) {
        if (credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    public boolean isNumericGrade() {
        return this.numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    @Override
    public String toString() {
        return String.format("[%s (%.2f cr), \"%s\". %s, period: %d.]",
                courseCode, credits, name, getCourseTypeString(), period);
    }

}

