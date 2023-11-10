package org.startsteps.model.role;

import org.startsteps.controller.course.CourseInterface;
import org.startsteps.model.course.Course;
import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private final int id;
    private final String name;
    private int age;
    private List<Course> courses;
    private CourseInterface courseInterface;

    public Student(String username, String password, int id, String name, int age, CourseInterface courseInterface) {
        super(username, password, UserRole.STUDENT);
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
        this.courseInterface = courseInterface;
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
