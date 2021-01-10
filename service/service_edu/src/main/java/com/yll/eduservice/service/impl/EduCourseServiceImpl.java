package com.yll.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yll.eduservice.entity.EduCourse;
import com.yll.eduservice.entity.EduCourseDescription;
import com.yll.eduservice.entity.EduTeacher;
import com.yll.eduservice.entity.vo.CourseInfoVo;
import com.yll.eduservice.entity.vo.CoursePublishVo;
import com.yll.eduservice.mapper.EduCourseMapper;
import com.yll.eduservice.service.EduCourseDescriptionService;
import com.yll.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yll.servicebase.exceptionhandler.GlobalExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Autowired
    private EduCourseDescriptionService descriptionService;

    @Override
    public String saveCouresInfo(CourseInfoVo courseInfoVo) {
        //向课程表中添加数据
        /**
         * 因为insert里面要EduCourse对象但传过来的是CourseInfoVo
         * 所以需要转换
         */
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if (insert == 0) {
            //添加失败
            throw new RuntimeException();
        }
        //向edu_course_description添加数据
        /**
         *
         */
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(eduCourse.getId());
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        descriptionService.save(eduCourseDescription);
        return eduCourse.getId();
    }

    @Override
    public CourseInfoVo getCourseInfoFormById(String courseId) {
        //QueryWrapper qw = new QueryWrapper();
        //qw.eq("id",courseId);
        //EduCourse eduCourse = baseMapper.selectOne(qw);
        EduCourse eduCourse = baseMapper.selectById(courseId);
        EduCourseDescription byId = descriptionService.getById(courseId);
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        courseInfoVo.setDescription(byId.getDescription());
        BeanUtils.copyProperties(eduCourse, courseInfoVo);
        return courseInfoVo;
    }

    @Override
    public void upDateCourseInfoVo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        baseMapper.updateById(eduCourse);
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        eduCourseDescription.setId(courseInfoVo.getId());
        descriptionService.updateById(eduCourseDescription);
    }

    @Override
    public CoursePublishVo publishCourseInfo(String courseId) {
        CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(courseId);
        return publishCourseInfo;
    }

    //分页课程列表
    @Override
    public void getAllCourses(IPage<EduCourse> pageParam, EduCourse eduCourse) {

        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        if (eduCourse == null) {
            baseMapper.selectPage(pageParam, wrapper);
            return;
        }
        //List<EduCourse> records = pageParam.getRecords();
        String title = eduCourse.getTitle();//课程名称
        String status = eduCourse.getStatus();//状态
        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if (StringUtils.isEmpty(status)) {
        } else {
            wrapper.eq("status", status);
        }
        wrapper.orderByAsc("gmt_modified ");
        baseMapper.selectPage(pageParam, wrapper);
    }


}
