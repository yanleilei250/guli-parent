package com.yll.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yll.eduservice.entity.EduTeacher;
import com.yll.eduservice.entity.vo.EduTeacherQuery;
import com.yll.eduservice.mapper.EduTeacherMapper;
import com.yll.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-07-24
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    @Override
    public void pageQuery(Page<EduTeacher> pageParam, EduTeacherQuery teacherQuery) {
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        //queryWrapper.orderByAsc("sort");
        if (teacherQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }
        String id = teacherQuery.getId();//ID
        String name = teacherQuery.getName();//名字
        Integer level = teacherQuery.getLevel();//职称
        String begin = teacherQuery.getBegin();//入职时间
        String end = teacherQuery.getEnd();//截至时间

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        if (StringUtils.isEmpty(level)) {
        } else {
            queryWrapper.eq("level", level);
        }
        if (StringUtils.isEmpty(id)) {
        } else {
            queryWrapper.eq("id", id);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_modified", end);
        }
        queryWrapper.orderByDesc("level");
        //gmtModified
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
