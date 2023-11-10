package org.startsteps.model.roles;

import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

public class Student extends User {
    private int id;
    private String name;
    private int age;

    public Student(String username, String password, int id, String name, int age) {
        super(username, password, UserRole.STUDENT);
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + "\nName: " + name + "\nAge: " + age + "\nCourses: ";
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
