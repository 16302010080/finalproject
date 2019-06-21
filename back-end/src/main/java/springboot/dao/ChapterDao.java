package springboot.dao;

import org.apache.ibatis.annotations.Param;
import springboot.domain.Chapter;

import java.util.List;

public interface ChapterDao {

    //查找的所有的章节
    List<Chapter> findAllChapter();

    //根据课程ID 查找相应的章节
    List<Chapter> findChapterOfCourse(@Param("courseID") int courseID);
}
