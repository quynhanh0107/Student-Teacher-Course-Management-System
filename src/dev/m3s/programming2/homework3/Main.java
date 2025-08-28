package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Create a student using the constructor with no parameters
        Student student = new Student("Donald", "Duck");
        //Degree degree = new Degree();

        ResponsibleTeacher resTeacher = new ResponsibleTeacher("Mouse", "Mickey");
        resTeacher.setBirthDate("230498-045T");
        MonthlyPayment payment = new MonthlyPayment();
        payment.setSalary(756.85);
        resTeacher.setPayment(payment);

        AssistantTeacher assTeacher = new AssistantTeacher("The Dog", "Goofy");
        assTeacher.setBirthDate("141200A2315");
        HourBasedPayment hourPayment = new HourBasedPayment();
        hourPayment.setEurosPerHour(3.5);
        hourPayment.setHours(11.0);
        assTeacher.setPayment(hourPayment);

        // 2. Create 11 Courses
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);

        List<DesignatedCourse> designatedCourses = new ArrayList<>();
        DesignatedCourse dc1 = new DesignatedCourse();
        dc1.setCourse(course3);
        dc1.setYear(2023);
        dc1.setResponsible(true);

        DesignatedCourse dc2 = new DesignatedCourse();
        dc2.setCourse(course4);
        dc2.setYear(2023);
        dc2.setResponsible(false);

        DesignatedCourse dc3 = new DesignatedCourse();
        dc3.setCourse(course4);
        dc3.setYear(2022);
        dc3.setResponsible(false);

        DesignatedCourse dc4 = new DesignatedCourse();
        dc4.setCourse(course4);
        dc4.setYear(2023);
        dc4.setResponsible(true);

        designatedCourses.add(dc1);
        designatedCourses.add(dc2);
        designatedCourses.add(dc3);
        designatedCourses.add(dc4);

        resTeacher.setCourses(designatedCourses);
        assTeacher.setCourses(designatedCourses);

        System.out.println(resTeacher.toString());
        System.out.println(assTeacher.toString());

        // 3. Create StudentCourses
        StudentCourse sc1 = new StudentCourse(course1, 1, 2013);
        StudentCourse sc2 = new StudentCourse(course2, 1, 2014);
        StudentCourse sc3 = new StudentCourse(course3, 1, 2015);
        StudentCourse sc4 = new StudentCourse(course4, 4, 2016);
        StudentCourse sc5 = new StudentCourse(course5, 5, 2017);
        StudentCourse sc6 = new StudentCourse(course6, 1, 2018);
        StudentCourse sc7 = new StudentCourse(course7, 1, 2019);
        StudentCourse sc8 = new StudentCourse(course8, 2, 2020);
        StudentCourse sc9 = new StudentCourse(course9, 0, 2021);
        StudentCourse sc10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse sc11 = new StudentCourse(course11, 'f', 2022);

        // 4. Array of bachelor StudentCourses
        StudentCourse[] bachelorCourses = {sc1, sc2, sc3, sc4, sc5};

        // 5. Array of master StudentCourses
        StudentCourse[] masterCourses = {sc6, sc7, sc8, sc9, sc10, sc11};

        // 6. Set the degreeTitle of the bachelor studies
        student.setDegreeTitle(0, "Bachelor of Science");

        // 7. Set the degreeTitle of the master studies
        student.setDegreeTitle(1, "Master of Science");

        // 8. Set title of bachelor thesis
        student.setTitleOfThesis(0, "Bachelor thesis title");

        // 9. Set title of master thesis
        student.setTitleOfThesis(1, "Masters thesis title");

        // 10. Add bachelor courses
        for (StudentCourse sc : bachelorCourses) {
            student.addCourse(0, sc);
        }

        // 11. Add master courses
        for (StudentCourse sc : masterCourses) {
            student.addCourse(1, sc);
        }

        // 12. Set start year
        student.setStartYear(2001);

        // 13. Set graduation year
        student.setGraduationYear(2020);

        // 14. Set first name
        student.setFirstName("Donald");

        // 15. Set last name
        student.setLastName("Duck");

        student.updateCredits();

        // 16. Print student details
        System.out.println(student.toString());

        // 17. Set birthdate
        student.setBirthDate("230498-045T");

        // 18. Update bachelor thesis title
        student.setTitleOfThesis(0, "Christmas - The most wonderful time of the year");

        // 19. Update master thesis title
        student.setTitleOfThesis(1, "Dreaming of a white Christmas");

        // 20. Print degrees
        student.printDegrees();

        //System.out.println("\n");

        // 21. Set grade for course 919191S
        sc9.setGrade(3);

        // 22. Print student details again
        System.out.println(student.toString());

        // 23. Print degrees again
        student.printDegrees();

        // 24. Print all courses
        student.printCourses();

      
    }
}

