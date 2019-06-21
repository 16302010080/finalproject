package springboot.controller;


import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Course;
import springboot.domain.Message;
import springboot.domain.Student;
import springboot.request.SqlSessionLoader;
import springboot.request.SuccessResponse;
import springboot.response.ErrorResponse;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/msg")
public class MessageController {
    @RequestMapping(value = "/recvMsg", method = RequestMethod.GET)
    public @ResponseBody Object recvMsg() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Message> messages = sqlSession.selectList("resources.mapper.StudentMapper.recvMsg");
        if (messages != null) {
            sqlSession.close();
            return messages;
        } else {
            sqlSession.close();
            return new ErrorResponse("没有消息记录"); // use your generated token here.
        }
    }
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    public @ResponseBody Object sendMsg(@RequestBody Message request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Message message = sqlSession.selectOne("resources.mapper.StudentMapper.check",request);
        if (message != null) {
            sqlSession.insert("resources.mapper.StudentMapper.sendMsg", new Message(request.getMessageID(),
                    request.getSender(),request.getTeacherID(),request.getStudentID(),request.getContent(),request.getSendTime()));
            sqlSession.commit();
            sqlSession.close();
            return new SuccessResponse("发送成功");
        }
        else {
            sqlSession.close();
            return new ErrorResponse("发送失败");
        }
    }
}
