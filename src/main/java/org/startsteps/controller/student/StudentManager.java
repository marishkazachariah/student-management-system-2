package org.startsteps.controller.student;

import org.startsteps.model.course.Course;
import org.startsteps.model.role.Student;

import java.util.List;
import java.util.Scanner;

public class StudentManager implements StudentInterface {
    private final List<Student> students;

    public StudentManager(List<Student> students) {
        this.students = students;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void edit(int studentID) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new/updated name of student:");
        String nameToEdit = scanner.next();
        for (Student student : students) {
            if (student.getId() == studentID) {
                student.setUsername(nameToEdit);
                return;
            }
        }
        System.out.println("Student not found.");
        scanner.close();
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }

    @Override
    public void displayRecords() {
        students.forEach(System.out::println);
    }

    @Override
    public List<Course> getEnrolledCourses(Student student) {
        return student.getCourses();
    }
}