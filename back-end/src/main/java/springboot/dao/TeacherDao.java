package springboot.dao;


import org.apache.ibatis.annotations.Param;
import springboot.domain.Course;
import springboot.domain.Homework;
import springboot.domain.Student;
import springboot.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherDao {


    /*
     * 根据教师的ID和课程的id，查看学生选课人数
     * 第一个Integer表示 teacherID， 第二个表示courseID
     */
    List<Student> findStudentToken(Map<Integer,Integer> map);

    /*
     * 根据教师的ID和课程的id，查看学生作业提交情况
     * 第一个Integer表示 teacherID， 第二个表示courseID
     */
    List<Homework> findHomework(Map<Integer,Integer> map);

    /*
     * 教师发布课程
     */
    String addCourse(Course course);
    /*
     * 教师注册
     */

    String addTeacher(Teacher teacher);


}
