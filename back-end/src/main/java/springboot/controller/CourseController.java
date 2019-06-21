package springboot.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Course;
import springboot.domain.Student;
import springboot.domain.Teacher;
import springboot.request.SqlSessionLoader;
import springboot.request.SuccessResponse;
import springboot.response.CourseResponse;
import springboot.response.ErrorResponse;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/home")
//首页课程
public class CourseController {
    @RequestMapping(value = "/listAllCourse", method = RequestMethod.GET)
    public @ResponseBody
    Object listAllCourse() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<CourseResponse> courses = sqlSession.selectList("resources.mapper.StudentMapper.listAllCourse");
        if (courses != null) {
            sqlSession.close();
            return courses;
        } else {
            sqlSession.close();
            return new ErrorResponse("没有课程信息"); // use your generated token here.
        }
    }

    //查询收藏的课程列表
    @RequestMapping(value = "/listCollectCourse", method = RequestMethod.POST)
    public @ResponseBody
    Object listCollectCourse(@RequestBody Student request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Course> courses = sqlSession.selectList("resources.mapper.StudentMapper.listCollectCourse",request.getStudentNickName());
//        return new ErrorResponse("test"+request.getStudentID());
        if (courses != null) {
            sqlSession.close();
            return courses;
        } else {
            sqlSession.close();
            return new ErrorResponse("没有收藏的课程信息"+request.getStudentID()); // use your generated token here.
        }
    }
    //添加课程
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public @ResponseBody Object addCourse(@RequestBody Course request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByName", request.getCourseName());
        if (course != null) {
            sqlSession.close();
            return new ErrorResponse("该课程已存在");
        } else {
            sqlSession.insert("resources.mapper.StudentMapper.addCourse", new Course(request.getCourseName(), request.getInstruction(), request.getCourseImageURL(), request.getIntroduction(), request.getPrice(), request.getStartTime()));
            sqlSession.commit();
            sqlSession.close();
            return new SuccessResponse("课程添加成功");
        }
    }
    //添加收藏课程
    @RequestMapping(value = "/addCollectCourse", method = RequestMethod.POST)
    public @ResponseBody Object addCollectCourse(@RequestBody Course request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByID", request.getCourseID());
        Student student=sqlSession.selectOne("resources.mapper.StudentMapper.findStuByNickName", request.getStudentNickName());
        int studentID;
        if(student!=null ){
            studentID=Integer.parseInt(String.valueOf(student.getStudentID()));
        }else {

            return new SuccessResponse("该学生不存在"+request.getStudentNickName());
        }
        if (course != null) {
            sqlSession.insert("resources.mapper.StudentMapper.addCollectCourse", new Course(
                    Integer.parseInt(String.valueOf(request.getCourseID())),studentID));
            sqlSession.commit();
            sqlSession.close();
//            sqlSession.close();
            return new ErrorResponse("课程添加收藏成功"+course.getCourseID()+studentID);
        } else {
//            sqlSession.insert("resources.mapper.StudentMapper.addCourse", new Course(request.getCourseName(), request.getInstruction(), request.getCourseImageURL(), request.getIntroduction(), request.getPrice(), request.getStartTime()));
//            sqlSession.commit();
//            sqlSession.close();
            return new SuccessResponse("该课程不存在"+request.getCourseID()+studentID);
        }
    }

    //添加参与课程
    @RequestMapping(value = "/addTokenCourse", method = RequestMethod.POST)
    public @ResponseBody Object addTokenCourse(@RequestBody CourseResponse request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByID", request.getCourseID());
        Student student=sqlSession.selectOne("resources.mapper.StudentMapper.findStuByNickName", request.getStudentNickName());
        int studentID;
        int teacherID= Integer.parseInt(String.valueOf(request.getTeacherID()));
        if(student!=null ){
            studentID=Integer.parseInt(String.valueOf(student.getStudentID()));
        }else {

            return new SuccessResponse("该学生不存在"+request.getStudentNickName());
        }
        if (course != null) {
            sqlSession.insert("resources.mapper.StudentMapper.addTokenCourse", new CourseResponse(
                    Integer.parseInt(String.valueOf(request.getCourseID())),studentID,teacherID));
            sqlSession.commit();
            sqlSession.close();
//            sqlSession.close();
            return new ErrorResponse("课程添加收藏成功"+course.getCourseID()+studentID);
        } else {
            return new SuccessResponse("该课程不存在"+request.getCourseID()+studentID);
        }
    }

    //该学生已参与课程
    @RequestMapping(value = "/myCourse", method = RequestMethod.GET)
    public @ResponseBody Object myCourse(@Param("studentNickName") String studentNickName ) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
//        studentNickName="Jong Dae";
        List<CourseResponse> course = sqlSession.selectList("resources.mapper.StudentMapper.listMyCourse");
        List<CourseResponse> result=new LinkedList<CourseResponse>();
        for(int i=0;i<course.size();i++){
            if(course.get(i).getStudentNickName().equals(studentNickName)){
                result.add(course.get(i));
            }
        }

        if (course != null) {
            sqlSession.close();
            if(result.size()!=0) return result;
            return new ErrorResponse("没有参与课程nnn"+studentNickName);
        } else {
            sqlSession.close();
            return new ErrorResponse("没有参与课程da"+studentNickName);
        }
    }

    //搜索课程---搜索框
    @RequestMapping(value = "/searchCourse", method = RequestMethod.POST)
    public @ResponseBody Object searchCourse(@RequestBody Course request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByName", request.getCourseName());
        if (course != null) {
            sqlSession.close();
            return course;
        } else {
            sqlSession.close();
            return new ErrorResponse("该课程不存在"+request.getCourseName());
        }
    }
    //搜索课程
    @RequestMapping(value = "/findCourse", method = RequestMethod.POST)
    public @ResponseBody Object searchCourseByID(@RequestBody Course request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByID", request.getCourseName());
        if (course != null) {
            sqlSession.close();
            return course;
        } else {
            sqlSession.close();
            return new ErrorResponse("该课程不存在");
        }
    }
}
