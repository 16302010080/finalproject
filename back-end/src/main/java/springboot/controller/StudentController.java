package springboot.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Course;
import springboot.domain.Student;
import springboot.request.SqlSessionLoader;
import springboot.request.SuccessResponse;
import springboot.response.ErrorResponse;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stu")
public class StudentController {
    //返回学生列表
    @RequestMapping(value = "/listAllStudent", method = RequestMethod.GET)
    public @ResponseBody
    Object listAllCourse() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Student> students = sqlSession.selectList("resources.mapper.StudentMapper.findAllStudent");
        if (students != null) {
            sqlSession.close();
            return students;
        } else {
            sqlSession.close();
            return new ErrorResponse("没有学生信息"); // use your generated token here.
        }
    }
    //返回学生
    @RequestMapping(value = "/findStuByNickName", method = RequestMethod.POST)
    public @ResponseBody
    Object findStudentByNick(@RequestBody Student request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Student student=sqlSession.selectOne("resources.mapper.StudentMapper.findStuByNickName", request.getStudentNickName());
        if (student != null) {
            sqlSession.close();
            return student;
        } else {
            sqlSession.close();
            return new ErrorResponse("没有该学生信息"+request.getStudentNickName()); // use your generated token here.
        }
    }
    @RequestMapping(value = "/msg", method = RequestMethod.POST)
    public @ResponseBody Object modify(@RequestBody Student request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Student student = sqlSession.selectOne("resources.mapper.StudentMapper.findStuByID",request.getStudentID());
        if (student != null) {
//            sqlSession.update("resources.mapper.StudentMapper.modifyStuMsg", new Student(request.getStudentID(), request.getStudentName(), request.getGender(),request.getEMail(), request.getAvatarURL()));
            sqlSession.update("resources.mapper.StudentMapper.modifyStuMsg", new Student(request.getStudentID(), request.getStudentName(),request.getStudentNickName(), request.getGender(),request.getEMail(), request.getAvatarURL()));
            sqlSession.commit();
            sqlSession.close();
            return new SuccessResponse("修改成功");
        }
        else {
            if(request==null) return new ErrorResponse("注册失败，request有空");
            if(request !=null) {
                sqlSession.insert("resources.mapper.StudentMapper.addStudent", new Student(
                        Integer.parseInt(String.valueOf(request.getStudentID())), request.getStudentName(), request.getStudentNickName(),
                        Integer.parseInt(String.valueOf(request.getGender())), request.getEMail(), request.getAvatarURL()));
                sqlSession.commit();
                sqlSession.close();
                return new ErrorResponse("注册成功"+request.getEMail()+request.getStudentID()+request.getStudentNickName()+request.getGender()+request.getStudentID()+request.getAvatarURL());
            }
            return new ErrorResponse("注册失败，参数有空"+request.getEMail()+request.getStudentID()+request.getStudentNickName()+request.getGender()+request.getStudentID()+request.getAvatarURL());
        }
    }
}