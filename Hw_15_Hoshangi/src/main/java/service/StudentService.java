package service;

import base.service.BaseService;
import model.Lesson;
import model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService extends BaseService<Student, Integer> {

    List<Student> loadAll();

    @Override
    Optional<Student> findById(Integer integer);

    void addCourseToStudent(Integer studentId, Lesson lesson);

    @Override
    Student login(String userName, String password);

    double getAverageMarksForStudent(Integer studentId);
}
