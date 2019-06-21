package springboot.dao;


import org.apache.ibatis.annotations.Param;
import springboot.domain.Course;
import springboot.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * 学生接口
 */

public interface StudentDao {


    /**
     * 获取学生信息列表
     *
     * @return
     */
    List<Student> findAllStudent();

    /**
     * 根据学号获取学生信息
     * 根据姓名获取学生信息
     * @param studentID
     * @return
     */
    Student findByNumber(@Param("studentID") int studentID);
    Student findByName(@Param("studentName") String studentName);

    // 完善学生信息
    String modifyStudent(Map<String,String> map);

    //学生--添加参与课程
    String tokenCourse(Course course);

    //学生删除参与的课程
    String deleteCourse(Course course);

}
