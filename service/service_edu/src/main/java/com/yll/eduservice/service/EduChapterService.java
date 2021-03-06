package com.yll.eduservice.service;

import com.yll.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yll.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-08-17
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean removeChapterById(String chapterId);
}
