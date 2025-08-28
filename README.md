# Student-Teacher Course Management System
* A Java-based **object-oriented programming project** that simulates the academic structure of a university.  
* It manages **students, teachers, courses, and degrees**, and demonstrates advanced Java features such as **abstract classes, inheritance, interfaces, encapsulation, and polymorphism**. 

---

## Overview
This system allows you to:  
- Register **students** and track their academic progress.  
- Define **courses** and assign them to teachers.  
- Track **bachelor’s and master’s degrees** with thesis requirements.  
- Manage **assistant and responsible teachers**, with flexible payment models.  
- Calculate **credits, GPA, and graduation eligibility**.  

It’s designed for practicing **OOP concepts in Java** while also modeling a real-world academic management system.  

---

## Key features
* OOP Principles (Abstract Classes, Inheritance, Interfaces, Encapsulation)  
* Birthdate validation with Finnish-style person ID logic (`PersonID`)  
* Flexible payment system (monthly or hourly)  
* Course assignment to teachers with responsibility tracking  
* Degree system (Bachelor’s + Master’s credits, GPA, thesis)  
* Readable student transcript output

---

## Functionality
### 1. Student Management  
- Each student has a unique ID, name, and birthdate (validated via `PersonID`).  
- Students can:  
  - Register for **Bachelor’s and Master’s degrees**.  
  - Add courses into different degrees.  
  - Track **credits earned** and **thesis titles**.  
  - Check eligibility for graduation.  
  - Calculate **study duration and GPA**.  

### 2. Course Management  
- Courses include:  
  - Name, course code (validated), course base (`A`, `P`, `S`), credits, period, grading type.  
- Supports **mandatory** and **optional** courses.  
- Student courses (`StudentCourse`) allow recording grades, status (passed/failed), and year.  

### 3. Degree Tracking  
- A student can have multiple degrees (Bachelor, Master, etc.).  
- Each degree:  
  - Stores up to 50 courses.  
  - Tracks credits by **course base** or **course type**.  
  - Computes GPA for mandatory, optional, or all courses.  
  - Holds a thesis title.  

### 4. Teacher & Employee Management  
- Two teacher roles:  
  - **AssistantTeacher** → Assists in courses.  
  - **ResponsibleTeacher** → Fully responsible for courses.  
- Teachers extend **Employee**, which extends `Person`.  
- Teachers can be paid using:  
  - **MonthlyPayment** (fixed salary).  
  - **HourBasedPayment** (hourly wage).  

### 5. Payment System  
- Uses a **Payment interface** for extensibility.  
- Current implementations:  
  - `MonthlyPayment` (fixed monthly salary).  
  - `HourBasedPayment` (hourly × worked hours).  
- Payments are calculated dynamically per teacher.  

### 6. GPA & Graduation Calculation  
- GPA computed separately for **Bachelor’s**, **Master’s**, and overall.  
- Graduation eligibility depends on:  
  - Credits earned (≥180 for Bachelor, ≥120 for Master).  
  - Thesis titles being set.  
- System validates **graduation year** and prevents invalid inputs.  

---

## Project Structure
### Core Classes
- **`Person` (abstract)** → Base class for all people.  
- **`PersonID`** → Validates person IDs and extracts birthdates.  
- **`Course`** → Defines course details.  
- **`DesignatedCourse`** → Assigns courses to teachers (with year & responsibility).  
- **`Degree`** → Tracks degree courses, credits, GPA, and thesis.  
- **`Student`** → Manages a student’s degrees, courses, graduation eligibility.  

### Teachers & Employees
- **`Employee` (abstract)** → Base class for employees. Implements `Payment`.  
  - **`AssistantTeacher`** → Assists courses.  
  - **`ResponsibleTeacher`** → Fully responsible for courses.  

### Payment Interfaces
- **`Payment`** → Interface for salary calculation.  
  - **`MonthlyPayment`** → Fixed salary.  
  - **`HourBasedPayment`** → Hourly × hours worked.  

### Teacher Interface
- **`Teacher`** → Interface defining teacher responsibilities.  

---

## Future Improvements
* Add GUI or web interface for easier interaction.
* Database integration for persistent student/course data.
* Support for PhD programs in addition to Bachelor/Master.
* Automated grading simulation.

---
Author: Quynh Anh Le\
Year: 2025
