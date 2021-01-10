package com.yll.eduservice.controller;


import com.yll.commonutils.R;
import com.yll.eduservice.entity.EduChapter;
import com.yll.eduservice.entity.chapter.ChapterVo;
import com.yll.eduservice.entity.chapter.VideoVo;
import com.yll.eduservice.service.EduChapterService;
import com.yll.eduservice.service.EduCourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-08-17
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class EduChapterController {
    @Autowired
    private EduChapterService chapterService;

    //课程大纲列表，根据课程id进行查询
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId) {
        List<ChapterVo> list = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("list", list);
    }

    //添加章节
    @ApiOperation(value = "添加章节")
    @PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter) {
        boolean b = chapterService.save(eduChapter);
        return b ? R.ok() : R.error();
    }

    //根据id查询章节
    @ApiOperation(value = "根据ID查询章节")
    @GetMapping("getChapter/{id}")
    public R getChapter(@PathVariable String id) {
        EduChapter chapter = chapterService.getById(id);
        return R.ok().data("chapter", chapter);
    }

    //根据id删除章节
    @ApiOperation(value = "根据ID删除章节")
    @DeleteMapping("deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable String chapterId) {
        boolean b = chapterService.removeChapterById(chapterId);
        return b ? R.ok() : R.error();
    }

    //根据id 修改章节
    @ApiOperation(value = "根据ID修改章节")
    @PutMapping("upDataChapter")
    public R upDataChapter(@RequestBody EduChapter educhapter) {
        chapterService.updateById(educhapter);
        return R.ok();
    }
}

