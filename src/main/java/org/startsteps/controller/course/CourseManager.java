package org.startsteps.controller.course;

import org.startsteps.model.course.Course;
import org.startsteps.model.role.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CourseManager implements CourseInterface {
    private final List<Course> courses;

    public CourseManager(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void add(Course course) {
        courses.add(course);
    }

    @Override
   public void edit(int courseID) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new/updated name of course:");
        String nameToEdit = scanner.next();

        for (Course course : courses) {
            if (course.getCourseID() == courseID) {
                course.setCourseName(nameToEdit);
                return;
            }
        }

        System.out.println("Course not found.");
        scanner.close();
    }

    @Override
    public void delete(Course course) {
        courses.remove(course);
    }

    @Override
    public void displayRecords() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public void enrollStudentInCourse(Student student, Course course) {
        if (courses.stream().anyMatch(c -> c.getCourseID() == course.getCourseID())) {
            System.out.println(student.getName() + " is already enrolled in this course.");
        } else {
            courses.add(course);
            System.out.println(student.getName() + " enrolled in course: " + course.getCourseName());
        }
    }

    @Override
    public List<Course> searchCourses(String searchTerm) {
        List<Course> searchResults = new ArrayList<>();
        for (Course course : getAllCourses()) {
            if (course.getCourseName().contains(searchTerm) || course.getCourseID() == Integer.parseInt(searchTerm)) {
                searchResults.add(course);
            }
        }
        return searchResults;
    }

    @Override
    public List<Course> sortCoursesByName() {
        return courses.stream()
                .sorted(Comparator.comparing(Course::getCourseName))
                .toList();
    }

    @Override
    public List<Course> sortCoursesById() {
        return courses.stream()
                .sorted(Comparator.comparing(Course::getCourseID))
                .toList();
    }
}