package com.yll.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yll.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yll.eduservice.entity.vo.EduTeacherQuery;

/**
 * @author testjava
 * @since 2020-07-24
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, EduTeacherQuery teacherQuery);
}
