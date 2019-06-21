package springboot.dao;

import org.apache.ibatis.annotations.Param;
import springboot.domain.Course;
import springboot.domain.Student;

import java.util.List;
import java.util.Map;

public interface CourseDao {

    //查找平台上的所有课程
    List<Course> findAllCourse();

    //根据学生ID查找学生所参与的课程
    List<Course> findCoursesToken(@Param("studentID") int studentID);


    /*
     * 根据学生学号和课程的id，查找课程的进度
     * 第一个Integer表示 studentID， 第二个表示courseID
     */
    Course processOfStudent(Map<Integer,Integer> map);
}
