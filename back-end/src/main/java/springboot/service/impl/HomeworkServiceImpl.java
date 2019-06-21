package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.dao.HomeworkDao;
import springboot.domain.Homework;
import springboot.service.HomeworkService;

import java.util.List;

public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    public HomeworkDao homeworkDao;
    @Override
    public List<Homework> findAllHomework() {
        return homeworkDao.findAllHomework();
    }

    @Override
    public List<Homework> findHomeworkOfStudent(int studentID) {
        return homeworkDao.findHomeworkOfStudent(studentID);
    }
}
