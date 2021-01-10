package com.yll.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yll.commonutils.R;
import com.yll.eduservice.entity.EduCourse;
import com.yll.eduservice.entity.vo.CourseInfoVo;
import com.yll.eduservice.entity.vo.CoursePublishVo;
import com.yll.eduservice.service.EduCourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {
    @Autowired
    EduCourseService eduCourseService;

    @ApiOperation(value = "添加课程")
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String id = eduCourseService.saveCouresInfo(courseInfoVo);
        return R.ok().data("id", id);
    }

    //removeDataById
    @ApiOperation(value = "根据ID删除课程")
    @DeleteMapping("removeDataById/{courseId}")
    public R removeDataById(@PathVariable String courseId) {
        eduCourseService.removeById(courseId);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfo = eduCourseService.getCourseInfoFormById(courseId);
        return R.ok().data("item", courseInfo);
    }

    @ApiOperation(value = "根据ID修改课程")
    @PostMapping("upDateCourseInfo")
    public R upDateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        eduCourseService.upDateCourseInfoVo(courseInfoVo);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询详情待发布")
    @GetMapping("getPublishCourseInfo/{courseId}")
    public R getPublishCourseInfo(@PathVariable String courseId) {
        CoursePublishVo cpv = eduCourseService.publishCourseInfo(courseId);
        return R.ok().data("cpv", cpv);
    }

    @ApiOperation(value = "根据ID修改状态发布")
    @GetMapping("publishCourseInfo/{courseId}")
    public R publishCourseInfo(@PathVariable String courseId) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(courseId);
        eduCourse.setStatus("Normal");
        boolean b = eduCourseService.updateById(eduCourse);
        return b ? R.ok() : R.error();
    }

    @ApiOperation(value = "课程列表分页带条件")
    @PostMapping("getAllCourseInfo/{page}/{limit}")
    public R getCourseInfo(@ApiParam(name = "page", value = "当前页码", required = true)
                           @PathVariable Long page,
                           @ApiParam(name = "limit", value = "每页记录数", required = true)
                           @PathVariable Long limit,
                           @ApiParam(name = "eduCourse", value = "查询对象", required = false)
                           @RequestBody EduCourse eduCourse) {
        IPage<EduCourse> pageParam = new Page<>(page, limit);
        eduCourseService.getAllCourses(pageParam, eduCourse);
        List<EduCourse> records = pageParam.getRecords();
        long total = pageParam.getTotal();//总记录数
        return R.ok().data("records", records).data("total", total);
    }

    @ApiOperation(value = "课程列表分页不带条件")
    @GetMapping("getAllCourse/{page}/{limit}")
    public R getCourse(@ApiParam(name = "page", value = "当前页码", required = true)
                       @PathVariable Long page,
                       @ApiParam(name = "limit", value = "每页记录数", required = true)
                       @PathVariable Long limit
    ) {
        IPage<EduCourse> pageParam = new Page<>(page, limit);
        eduCourseService.page(pageParam, null);
        List<EduCourse> records = pageParam.getRecords();
        long total = pageParam.getTotal();//总记录数
        return R.ok().data("records", records).data("total", total);
    }
}

