package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.dao.CourseDao;
import springboot.domain.Course;
import springboot.service.CourseService;

import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {

   @Autowired
   public CourseDao courseDao;
    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAllCourse();
    }

    @Override
    public List<Course> findCoursesToken(int studentID) {
        return courseDao.findCoursesToken(studentID);
    }

    @Override
    public Course processOfStudent(Map<Integer, Integer> map) {
        return courseDao.processOfStudent(map);
    }
}
