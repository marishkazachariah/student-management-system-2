package org.startsteps.controller.course;

import org.startsteps.model.course.Course;
import org.startsteps.model.crud.CRUD;
import org.startsteps.model.role.Student;

import java.util.List;

public interface CourseInterface extends CRUD<Course> {
    List<Course> getAllCourses();
    void enrollStudentInCourse(Student student, Course course);
    List<Course> searchCourses(String searchTerm);
    List<Course> sortCoursesByName();
    List<Course> sortCoursesById();
}