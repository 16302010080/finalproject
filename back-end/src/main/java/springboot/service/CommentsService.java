package springboot.service;

import org.apache.ibatis.annotations.Param;
import springboot.domain.Comments;

import java.util.List;

public interface CommentsService {

    List<Comments> findAllComments();
    List<Comments> findCommentsOfStudent(int studentID);
    List<Comments> findCommentsOfTeacher(int teacherID);
}
