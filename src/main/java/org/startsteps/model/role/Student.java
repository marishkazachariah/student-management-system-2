package org.startsteps.model.role;

import org.startsteps.controller.course.CourseInterface;
import org.startsteps.model.course.Course;
import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private int id;
    private String name;
    private int age;
    private List<Course> courses;
    private CourseInterface courseRepo;

    public Student(String username, String password, int id, String name, int age, CourseInterface courseRepository) {
        super(username, password, UserRole.STUDENT);
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
        this.courseRepo = courseRepository;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void enrollInCourse(Course course) {
        courseRepo.enrollStudentInCourse(this, course);
    }

    public void editCourse(int courseId) {
        courseRepo.edit(courseId);
    }

    public void displayEnrolledCourses() {
        System.out.println("Courses enrolled in:");
        for (Course course : courses) {
            System.out.println("Course name: " + course.getCourseName());
            System.out.println("Course ID: " + course.getCourseID());
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + id + "\nName: " + name + "\nAge: " + age + "\nCourses: " + courses;
    }

    @Override
    public void displayRoleSpecificMenu() {
        System.out.println("Welcome " + getUsername() + "!");
        System.out.println("Student Menu:");
        System.out.println("1. View Courses");
        System.out.println("2. Edit Data");
        System.out.println("3. Delete Account");
    }
}
