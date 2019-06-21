package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.dao.ChapterDao;
import springboot.domain.Chapter;
import springboot.service.ChapterService;

import java.util.List;

public class ChapterServiceImpl implements ChapterService {

    @Autowired
    public ChapterDao chapterDao;

    @Override
    public List<Chapter> findAllChapter() {
        return chapterDao.findAllChapter();
    }

    @Override
    public List<Chapter> findChapterOfCourse(int courseID) {
        return chapterDao.findChapterOfCourse(courseID);
    }
}
