package springboot.dao;

import org.apache.ibatis.annotations.Param;
import springboot.domain.Homework;

import java.util.List;

public interface HomeworkDao {

    //查找的所有的作业
    List<Homework> findAllHomework();

    //根据学生学号查找TA相应的作业列表
    List<Homework> findHomeworkOfStudent(@Param("studentID") int studentID);

    //
}
