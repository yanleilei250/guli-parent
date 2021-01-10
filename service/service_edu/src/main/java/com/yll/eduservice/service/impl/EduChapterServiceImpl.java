package com.yll.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yll.eduservice.entity.EduChapter;
import com.yll.eduservice.entity.EduVideo;
import com.yll.eduservice.entity.chapter.ChapterVo;
import com.yll.eduservice.entity.chapter.VideoVo;
import com.yll.eduservice.mapper.EduChapterMapper;
import com.yll.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yll.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-08-17
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    @Autowired
    EduVideoService eduVideoService;

    //课程大纲列表，根据课程id进行查询
    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapperChapter = new QueryWrapper<>();
        wrapperChapter.eq("course_id", courseId);
        List<EduChapter> eduChapters = baseMapper.selectList(wrapperChapter);

        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        wrapperVideo.eq("course_id", courseId);
        List<EduVideo> eduVideoList = eduVideoService.list(wrapperVideo);

        List<ChapterVo> finalList = new ArrayList<>();

        for (int i = 0; i < eduChapters.size(); i++) {
            EduChapter eduChapter = eduChapters.get(i);
            ChapterVo chapterVo = new ChapterVo();
            chapterVo.setId(eduChapter.getId());
            chapterVo.setTitle(eduChapter.getTitle());
            finalList.add(chapterVo);
            List<VideoVo> children = chapterVo.getChildren();
            for (int j = 0; j < eduVideoList.size(); j++) {
                EduVideo eduVideo = eduVideoList.get(j);
                if (eduVideo.getChapterId().equals(eduChapter.getId())) {
                    VideoVo videoVo = new VideoVo();
                    videoVo.setId(eduVideo.getId());
                    videoVo.setTitle(eduVideo.getTitle());
                    children.add(videoVo);
                }
            }
        }
        return finalList;
    }


    @Override
    public boolean removeChapterById(String chapterId) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id", chapterId);
        int count = eduVideoService.count(wrapper);
        if (count > 0) {
            return false;
        }
        int i = baseMapper.deleteById(chapterId);
        return true;
    }
}
