package com.yll.eduservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yll.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yll.eduservice.entity.vo.CourseInfoVo;
import com.yll.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-08-17
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCouresInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfoFormById(String courseId);

    void upDateCourseInfoVo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String courseId);

    //带条件
    void getAllCourses(IPage<EduCourse> pageParam, EduCourse eduCourse);

}
