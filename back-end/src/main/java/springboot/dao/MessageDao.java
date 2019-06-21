package springboot.dao;

import org.apache.ibatis.annotations.Param;
import springboot.domain.Message;

import java.util.List;
import java.util.Map;

public interface MessageDao {

    //查找的所有对话
    List<Message> findAllMessage();

    /*
     * 查找的所有某个教师与某个学生的对话
     * 第一个Integer表示 teacherID， 第二个表示studentID
     */
    List<Message> findMessageOfTS(Map<Integer,Integer> map);

    //添加对话
    String addMessage(Message message);
}
