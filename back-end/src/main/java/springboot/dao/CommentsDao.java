package springboot.dao;

import org.apache.ibatis.annotations.Param;
import springboot.domain.Comments;
import springboot.domain.Homework;

import java.util.List;

public interface CommentsDao {

    //查找的所有的评论
    List<Comments> findAllComments();

    //根据学生学号查找相应的评论
    List<Comments> findCommentsOfStudent(@Param("studentID") int studentID);

    //根据教师账号查找相应的评论
    List<Comments> findCommentsOfTeacher(@Param("teacherID") int teacherID);
}
