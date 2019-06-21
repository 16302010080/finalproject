package springboot.service;

import org.springframework.stereotype.Repository;
import springboot.domain.Course;
import springboot.domain.Student;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentService {


    List<Student> findAllStudent();

    Student findByNumber(int studentID);
    Student findByName(String studentName);

    // 完善学生信息
    String modifyStudent(Map<String,String> map);

    //学生--添加参与课程
    String tokenCourse(Course course);

    //学生删除参与的课程
    String deleteCourse(Course course);
}
