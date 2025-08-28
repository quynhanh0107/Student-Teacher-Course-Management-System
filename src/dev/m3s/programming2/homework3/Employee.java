package dev.m3s.programming2.homework3;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

interface Payment {
    abstract double calculatePayment();
}

interface Teacher {
    abstract String getCourses();
}

public abstract class Employee extends Person implements Payment {
    private String empId;
    private int startYear; 
    private Payment payment; 

    public Employee(String lname, String fname) {
        super(lname, fname);
        int idNum = getRandomId(2001, 3000);
        this.empId = String.format(getEmployeeIdString() + "%04d", idNum); 
        this.startYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    public String getIdString() {
        return this.empId;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (startYear > 2000 && startYear <= currentYear) {
            this.startYear = startYear;
        } else {
            this.startYear = currentYear;
        }
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        if (payment != null) {
            this.payment = payment;
        }
    }

    @Override
    public double calculatePayment() {
        if (this.payment != null) {
            return this.payment.calculatePayment();
        } else {
            return 0.0;
        }
    }
    
    abstract protected String getEmployeeIdString();
    
}

class MonthlyPayment implements Payment {
    private double salary = 0.0;

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if (salary > 0.0) {
            this.salary = salary;
        }
    }

    @Override
    public double calculatePayment() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%.2f", salary);
    }
}

class HourBasedPayment implements Payment {
    private double eurosPerHour = 0.0;
    private double hours = 0.0;

    public double getEurosPerHour() {
        return this.eurosPerHour;
    }

    public void setEurosPerHour(double eurosPerHour) {
        if (eurosPerHour > 0.0) {
            this.eurosPerHour = eurosPerHour;
        }
    }

    public double getHours() {
        return this.hours;
    }

    public void setHours(double hours) {
        if (hours > 0.0) {
            this.hours = hours; 
        }
    }

    @Override
    public double calculatePayment() {
        return hours * eurosPerHour;
    }

    @Override
    public String toString() {
        return String.format("%.2f", calculatePayment());
    }
}

class AssistantTeacher extends Employee implements Teacher {
    private List<DesignatedCourse> courses = new ArrayList<>();

    public AssistantTeacher(String lname, String fname ) {
        super(lname, fname);
    }

    public String getEmployeeIdString() {
        return "OY_ASSISTANT_";
    }

    public String getCourses() {
        StringBuilder sb = new StringBuilder();
        
        //Utilize toString method of the DesignatedCourse class
        for(DesignatedCourse course : courses) {
            sb.append(course.toString()).append("\n");
        }
        return sb.toString().trim();
    }

    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses;
        }
    }

    public String toString() {
        return "Teacher id: " + getIdString() + "\n" +
                "First name: " + getFirstName() + ", Last name: " + getLastName() + "\n" +
                "Birthdate: " + getBirthDate() + "\n" + 
                "Salary: " + getPayment() + "\n" +
                "Assistant for courses: " + "\n" +
                getCourses() + "\n";
    }
}

class ResponsibleTeacher extends Employee implements Teacher {
    private List<DesignatedCourse> courses;

    public ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
        this.courses = new ArrayList<>();
    }

    public String getEmployeeIdString() {
        return "OY_TEACHER_";
    }

    public String getCourses() {
        StringBuilder sb = new StringBuilder();
        
        //Utilize toString method of the DesignatedCourse class
        for(DesignatedCourse course : courses) {
            if (course.isResponsible()) {
                sb.append("Responsible teacher: ").append(course.toString()).append("\n");
            } else {
                sb.append("Teacher: ").append(course.toString()).append("\n");
            }
        }
        return sb.toString().trim();
    }

    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses; 
        }
    }

    @Override
    public String toString() {
        return "Teacher id: " + getIdString() + "\n" +
                "First name: " + getFirstName() + ", Last name: " + getLastName() + "\n" +
                "Birthdate: " + getBirthDate() + "\n" + 
                "Salary: " + getPayment() + "\n" +
                "Teacher for courses: " + "\n" +
                getCourses() + "\n";
    }
}
