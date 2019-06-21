package springboot.service;

import springboot.domain.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    List<Course> findAllCourse();
    List<Course> findCoursesToken(int studentID);
    Course processOfStudent(Map<Integer,Integer> map);
}
