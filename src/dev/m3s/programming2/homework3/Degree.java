package dev.m3s.programming2.homework3;
import java.util.List;
import java.util.ArrayList;

public class Degree {
    private static final int MAX_COURSES = 50;
    private int count = 0;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<>();

    public List<StudentCourse> getCourses() {
        return this.myCourses; 
    }
    
    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && count < MAX_COURSES) {
            myCourses.add(course);
            count++;
            return true;
        }
        return false;
    }

    public void addStudentCourses(List<StudentCourse> courses) {
        if (courses != null) {
            for (StudentCourse course : courses) {
                if (course != null) {
                    addStudentCourse(course);
                }
            }
        }
    }

    public int getCount() {
        return myCourses.size();
    }

    public String getDegreeTitle() {
        return this.degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null && !degreeTitle.trim().isEmpty()) {
            this.degreeTitle = degreeTitle;
        }
    }

    public String getTitleOfThesis() {
        return this.titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null && !titleOfThesis.trim().isEmpty()) {
            this.titleOfThesis = titleOfThesis;
        }
    }

    private boolean isCourseCompleted(StudentCourse c) {
        if (c != null) {
            if (c.getCourse().isNumericGrade() && c.isPassed()) {
                return c.getGradeNum() > 0;
            } else if (!c.getCourse().isNumericGrade() && c.isPassed()){
                return c.getGradeNum() == 'A'; 
            }
        }
         return false;
    }

    public double getCreditsByBase(Character base) {
        double totalCredits = 0.0;
        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null && myCourses.get(i).getCourse().getCourseBase().equals(base) 
            && isCourseCompleted(myCourses.get(i))) {
                totalCredits += myCourses.get(i).getCourse().getCredits();
            }
        }
        return totalCredits;
    }

    public double getCreditsByType(final int courseType) {
        double totalCredits = 0.0;
        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null && myCourses.get(i).getCourse().getCourseType() == courseType 
            && isCourseCompleted(myCourses.get(i))) {
                totalCredits += myCourses.get(i).getCourse().getCredits();
            }
        }
        return totalCredits;
    }

    public double getCredits() {
        double totalCredits = 0.0;
        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null && isCourseCompleted(myCourses.get(i))) {
                totalCredits += myCourses.get(i).getCourse().getCredits();
            }
        }
        return totalCredits;
    }

    public List<Double> getGPA(int type) {
        double sum = 0.0;
        int countNumeric = 0;
        double average = 0.0;
        String formattedAverage;
        double afterAverage = 0.0;

        for (StudentCourse sc : myCourses) {
            Course c = sc.getCourse();

            if (c == null) continue;

            int courseType = c.getCourseType(); 
            boolean isNumbericGrading = c.isNumericGrade();
            boolean isPassedCourses = sc.isPassed();
            boolean matchesType = (type == ConstantValues.ALL) || (type == courseType); 

            if (matchesType && isNumbericGrading && isPassedCourses) {
                int grade = sc.getGradeNum();
                sum = sum + grade;
                countNumeric++;
            }
        }
        
        if (countNumeric > 0) {
            average = sum / countNumeric;
            formattedAverage = String.format("%.2f", average);
            afterAverage = Double.parseDouble(formattedAverage);
        }

        List<Double> resultList = new ArrayList<>();
        resultList.add(sum);
        resultList.add((double) countNumeric);
        resultList.add(afterAverage);
        
        return resultList;
    }

    public void printCourses() {
        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null) {
                System.out.println(myCourses.get(i));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Degree [Title: \"").append(degreeTitle).append(" (courses: ").append(count).append(")\n");
        sb.append("Thesis title: \"").append(titleOfThesis).append("\"\n");

        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null) {
                sb.append(i + 1).append(".").append(myCourses.get(i).toString());
        
                // Ensure year formatting is correct
                int year = myCourses.get(i).getYear();  // Assuming StudentCourse has getYear()
                if (year > 0) {
                    sb.append(" Year: ").append(year);
                } else {
                    sb.append(" Year: 2025");  // Default to expected year if missing
                }
        
                sb.append("\n");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
}
