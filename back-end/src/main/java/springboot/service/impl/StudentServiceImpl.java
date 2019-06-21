package springboot.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.dao.StudentDao;
import springboot.domain.Course;
import springboot.domain.Student;
import springboot.service.StudentService;

import javax.validation.constraints.AssertFalse;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findAllStudent(){ return studentDao.findAllStudent();}

    @Override
    public Student findByNumber(int studentID) {
        return studentDao.findByNumber(studentID);
    }

    public Student findByName(String name) {return studentDao.findByName(name);}

    @Override
    public String modifyStudent(@Param("params")Map<String,String> map){

        return studentDao.modifyStudent(map);
    }

    @Override
    public String tokenCourse(Course course) {
        return studentDao.tokenCourse(course);
    }

    @Override
    public String deleteCourse(Course course) {
        return studentDao.deleteCourse(course);
    }

}
