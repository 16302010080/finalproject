package springboot.service;

import springboot.domain.Chapter;

import java.util.List;

public interface  ChapterService {

    List<Chapter> findAllChapter();
    List<Chapter> findChapterOfCourse(int courseID);
}
