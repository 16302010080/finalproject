package springboot.service;

import springboot.domain.Course;
import springboot.domain.Homework;
import springboot.domain.Student;
import springboot.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    List<Student> findStudentToken(Map<Integer,Integer> map);

    List<Homework> findHomework(Map<Integer,Integer> map);

    String addCourse(Course course);
    String addTeacher(Teacher teacher);
}
