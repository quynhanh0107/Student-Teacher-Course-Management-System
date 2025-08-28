package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Student extends Person {
    private int id;
    private int startYear = Calendar.getInstance().get(Calendar.YEAR);
    private int graduationYear;
    private double bachelorCredits = ConstantValues.MIN_CREDITS;
    private double masterCredits = ConstantValues.MIN_CREDITS;
    private String titleOfBachelorsThesis = ConstantValues.NO_TITLE;
    private String titleOfMastersThesis = ConstantValues.NO_TITLE;
    private int degreeCount = 3;
    private List<Degree> degrees = new ArrayList<>();
    private Degree degreeClass = new Degree();

    public Student(String lname, String fname) {
        super(lname, fname);
        this.id = getRandomId(1, 100);

        for (int i = 0; i < degreeCount; i++) {
            degrees.add(new Degree());
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        if (id >= ConstantValues.MIN_STUDENT_ID && id <= ConstantValues.MAX_STUDENT_ID) {
            this.id = id;
        } 
    }

    public int getStartYear() {
        return this.startYear;
    }

    public void setStartYear(final int startYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (startYear > 2000 && startYear <= currentYear) {
            this.startYear = startYear;
        } else {
            this.startYear = currentYear;
        }
    }

    public int getGraduationYear() {
        return this.graduationYear;
    }

    public String setGraduationYear(final int graduationYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        if (!canGraduate()) {
            return "Check the amount of required credits!";
        }

        if (graduationYear < startYear || graduationYear > currentYear) {
            return "Check graduation year";
        }
    
        this.graduationYear = graduationYear;
        return "OK";
    }

    private boolean canGraduate() {
        if (bachelorCredits >= ConstantValues.BACHELOR_CREDITS 
            && masterCredits >= ConstantValues.MASTER_CREDITS 
            && !ConstantValues.NO_TITLE.equals(titleOfBachelorsThesis)
            && !ConstantValues.NO_TITLE.equals(titleOfMastersThesis)) {
                return true;
        }
        return false;
    }

    public boolean hasGraduated() {
        if (graduationYear != 0) {
            return true;
        }
        return false;
    }

    public int getStudyYears() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (hasGraduated()) {
            return graduationYear - startYear;
        } else {
            return currentYear - startYear;
        }
    }

    public double getBachelorCredits() {
        return this.bachelorCredits;
    }

    public void setBachelorCredits(final double bachelorCredits) {
        if (bachelorCredits >= ConstantValues.MIN_CREDITS && bachelorCredits <= ConstantValues.MAX_CREDITS) {
            this.bachelorCredits = bachelorCredits;
        } else {
            System.out.println("Bachlor credits must be within " + ConstantValues.MIN_CREDITS + " - " + ConstantValues.MAX_CREDITS);
        }
    }

    public double getMasterCredits() {
        return this.masterCredits;
    }

    public void setMasterCredits(final double masterCredits) {
        if (masterCredits >= ConstantValues.MIN_CREDITS && masterCredits <= ConstantValues.MAX_CREDITS) {
            this.masterCredits = masterCredits;
        } else {
            System.out.println("\n\nMaster credits must be within " + ConstantValues.MIN_CREDITS + " - " + ConstantValues.MAX_CREDITS);
        }
    }

    public String getTitleOfBachelorsThesis() {
        return this.titleOfBachelorsThesis;
    }

    public void setTitleOfBachelorsThesis(String title ) {
        if (title != null && !title.trim().isEmpty()) {
            titleOfBachelorsThesis = title;
        } else {
            titleOfBachelorsThesis = ConstantValues.NO_TITLE;
        }
    }

    public String getTitleOfMastersThesis() {
        return titleOfMastersThesis;
    }

    public void setTitleOfMastersThesis(String title ) {
        if (title != null && !title.trim().isEmpty()) {
            titleOfMastersThesis = title;
        } else {
            titleOfMastersThesis = ConstantValues.NO_TITLE;
        }
    }
    
    public void setDegreeTitle(final int i, String dName) {
        if (dName != null && i >= 0 && i < degrees.size()) {
            if (degrees.get(i) == null) {
                degrees.set(i, new Degree());
                degreeCount++;
            }
            degrees.get(i).setDegreeTitle(dName);
        }
    }

    public boolean addCourse(final int i, StudentCourse courses) {
        if (courses != null && i >= 0 && i < degrees.size() && degrees.get(i) != null) {
            Degree degree = degrees.get(i); 
            if (degree.getCount() >= 50) {
                return false;
            }

            degrees.get(i).addStudentCourse(courses);
            updateCredits();
            return true;
        }
        return false; 
    }

    public int addCourses(final int i, List<StudentCourse> courses) {
        int courseCountBefore = 0;
        int courseCountAfter = 0;

        if (courses != null && i >= 0 && i < degrees.size() && degrees.get(i) != null) {
            courseCountBefore = degrees.get(i).getCount();
            degrees.get(i).addStudentCourses(courses);
            courseCountAfter = degrees.get(i).getCount(); 
        }
        return courseCountAfter - courseCountBefore;
    }

    public void updateCredits() {
        if (degrees.get(0) != null) {
            setBachelorCredits(degrees.get(0).getCredits());
        }
        if (degrees.get(1) != null) {
            setMasterCredits(degrees.get(1).getCredits());
        }
    }

    public void printCourses() {
        for (int i = 0; i < degrees.size(); i++) {
            if (degrees.get(i) != null) {
                degrees.get(i).printCourses();
            }
        }
    }
 
    public void printDegrees() {
        for (int i = 0; i < degrees.size(); i++) {
            if (degrees.get(i) != null) {
                System.out.println(degrees.get(i).toString());
            }
        }
    }

    public void setTitleOfThesis(final int i, String title) {
        if (title != null && i >= 0 && i < degrees.size() && degrees.get(i) != null) {
            degrees.get(i).setTitleOfThesis(title);
        }

        if (i == 0) {
            this.titleOfBachelorsThesis = title;
        } else if (i == 1) {
            this.titleOfMastersThesis = title;
        }

    }

    public String getIdString() {
        String idString = String.format("Student ID: %d", id);

        return idString; 
    }

    @Override
    public String toString() {
        double totalCredits = 0.0;
        double bachelorMandatoryCredits = 0.0;
        double masterMandatoryCredits = 0.0;
        
        double bachelorGrades = 0.0;
        double masterGrades = 0.0;
        int bachelorGradedCourses = 0;
        int masterGradedCourses = 0; 

        for (int i = 0; i < degrees.size(); i++) {
            Degree degree = degrees.get(i);

            //Calculate the total credits
            if (degree != null) {
                totalCredits += degree.getCredits();
            }
            
            List<StudentCourse> courses = degree.getCourses();

            //Calculate mandatory courses' credits 
            for (StudentCourse sc : courses) {
                Course c = sc.getCourse();
                if (c.getCourseType() == 1 && sc.isPassed()) {
                    if (i == 0) {
                        bachelorMandatoryCredits += c.getCredits();
                    } else if (i == 1) {
                        masterMandatoryCredits += c.getCredits();
                    }
                } 
                
                // Calculate sum and counts for grades in master and bachelor
                if (c.isNumericGrade() && sc.isPassed()) {
                    if (i == 0) {
                        bachelorGrades += sc.getGradeNum();
                        bachelorGradedCourses++;
                    } else if (i == 1) {
                        masterGrades += sc.getGradeNum();
                        masterGradedCourses++;
                    }
                }

            }
        }

        //Get the list of sum, count, average for all courses (both master and bachelor)
        for (Degree degree : degrees) {
            degreeClass.addStudentCourses(degree.getCourses());
        }
        List<Double> gpaAll = degreeClass.getGPA(ConstantValues.ALL);

        double gpaBachelor = bachelorGradedCourses > 0 ? bachelorGrades / bachelorGradedCourses : 0.0;
        double gpaMaster = masterGradedCourses > 0 ? masterGrades / masterGradedCourses : 0.0;
        
        
        String formattedGPABachelor = String.format("%.2f", gpaBachelor);
        String formattedGPAMaster = String.format("%.2f", gpaMaster);

        return "***\n" +
                "Student id: " + this.id + "\n" +
                "First name: " + (getFirstName() != null ? getFirstName() : ConstantValues.NO_NAME) + ", Last Name: " + (getLastName() != null ? getLastName() : ConstantValues.NO_NAME) + "\n" +
                "Date of birth: " + getBirthDate() + "\n" +
                "Status: " + (hasGraduated() ? "Student has graduated in " + graduationYear : "Student has not graduated, yet") + "\n" +
                "Start year: " + startYear + " (studies have lasted for " + getStudyYears() + " years)" + "\n" +
                "Total credits: " + totalCredits + " (GPA = " + gpaAll.get(2)  + ")" + "\n" +
                "Bachelor credits: " + bachelorCredits + "\n" +
                "Total bachelor credits completed (" + bachelorCredits + "/180.0)\n" +
                "All mandatory bachelor credits completed (" + bachelorMandatoryCredits + "/150.0)" + "\n" +
                "GPA of Bachelor studies: " + formattedGPABachelor + "\n" +
                "Title of BSc Thesis: \"" + titleOfBachelorsThesis + "\"\n" +
                "Master credits: " + masterCredits + "\n" +
               (masterCredits >= ConstantValues.MASTER_CREDITS ? "Total master's credits completed (" + masterCredits + "/120.0)\n"
                          : "Missing master's credits " + Math.round((ConstantValues.MASTER_CREDITS - masterCredits) * 10.0) / 10.0  + " (" + masterCredits + "/120.0)\n") +
                "All mandatory master credits completed (" + masterMandatoryCredits + "/50.0)" + "\n" +
                "GPA of Master studies: " + formattedGPAMaster + "\n" +
                "Title of MSc Thesis: \"" + titleOfMastersThesis + "\"\n";
    }
}


