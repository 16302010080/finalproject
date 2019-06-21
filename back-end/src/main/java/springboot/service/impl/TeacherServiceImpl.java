package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.dao.TeacherDao;
import springboot.domain.Course;
import springboot.domain.Homework;
import springboot.domain.Student;
import springboot.domain.Teacher;
import springboot.service.TeacherService;

import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    public TeacherDao teacherDao;
    @Override
    public List<Student> findStudentToken(Map<Integer, Integer> map) {
        return teacherDao.findStudentToken(map);
    }

    @Override
    public List<Homework> findHomework(Map<Integer, Integer> map) {
        return teacherDao.findHomework(map);
    }

    @Override
    public String addCourse(Course course) {
        return teacherDao.addCourse(course);
    }

    @Override
    public String addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }
}
