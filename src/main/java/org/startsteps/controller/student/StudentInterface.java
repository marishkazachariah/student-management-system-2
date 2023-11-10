package org.startsteps.controller.student;

import org.startsteps.model.course.Course;
import org.startsteps.model.crud.CRUD;
import org.startsteps.model.role.Student;

import java.util.List;

public interface StudentInterface extends CRUD<Student> {
    List<Course> getEnrolledCourses(Student student);
}
