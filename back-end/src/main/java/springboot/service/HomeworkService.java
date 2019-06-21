package springboot.service;

import springboot.domain.Homework;

import java.util.List;

public interface HomeworkService {

    List<Homework> findAllHomework();
    List<Homework> findHomeworkOfStudent(int studentID);
}
