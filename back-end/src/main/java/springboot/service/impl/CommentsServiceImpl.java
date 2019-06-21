package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.dao.CommentsDao;
import springboot.domain.Comments;
import springboot.service.CommentsService;

import java.util.List;

public class CommentsServiceImpl implements CommentsService {


    @Autowired
    public CommentsDao commentsDao;
    @Override
    public List<Comments> findAllComments() {
        return commentsDao.findAllComments();
    }

    @Override
    public List<Comments> findCommentsOfStudent(int studentID) {
        return commentsDao.findCommentsOfStudent(studentID);
    }

    @Override
    public List<Comments> findCommentsOfTeacher(int teacherID) {
        return commentsDao.findCommentsOfTeacher(teacherID);
    }
}
