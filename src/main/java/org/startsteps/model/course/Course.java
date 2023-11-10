package org.startsteps.model.course;

import org.startsteps.model.crud.CRUD;
import org.startsteps.model.role.Student;

import java.util.*;

public class Course {
    private final int courseID;
    private String courseName;
    private final List<Student> enrolledStudents;
    private final Map<Student, Double> grades;

    public Course(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.grades = new HashMap<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addGrade(Student student, double grade) {
        if (enrolledStudents.contains(student) && grade >= 0 && grade <= 100) {
            grades.put(student, grade);
            System.out.println("Grade added for " + student.getName());
        } else {
            System.out.println("Student " + student.getName() + " is not enrolled in this course.");
        }
    }

    public void editGrade(Student student, double grade) {
        if (enrolledStudents.contains(student) && grades.containsKey(student)
                && grade >= 0 && grade <= 100) {
            grades.put(student, grade);
            System.out.println("Grade updated for " + student.getName());
        } else if (!enrolledStudents.contains(student)) {
            System.out.println("Student " + student.getName() + " is not enrolled in this course.");
        } else {
            System.out.println("Student " + student.getName() + " does not have a grade to edit.");
        }
    }

    public void displayStudentGrades() {
        System.out.println("Grades for Course: " + courseName);
        for (Map.Entry<Student, Double> entry : grades.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " Grade: " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Course Name: " + courseName + "\nCourse ID: " + courseID +
                "\nEnrolled Students: " + enrolledStudents;
    }
}
