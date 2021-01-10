package com.yll.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yll.eduservice.entity.EduSubject;
import com.yll.eduservice.entity.excel.SubjectData;
import com.yll.eduservice.service.EduSubjectService;

import java.sql.Wrapper;

/**
 * @author 颜起名
 * @create date 2020-08-05-21:29
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    public EduSubjectService eduSubjectService;

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    public SubjectExcelListener() {
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null) {
            throw new RuntimeException("空的Subject");
        }
        //判断一级分类是否重复
        EduSubject existoneSubject = this.existOneSubhect(eduSubjectService, subjectData.getOneSubjectName());
        if (existoneSubject == null) {
            existoneSubject = new EduSubject();
            existoneSubject.setParentId("0");
            existoneSubject.setTitle(subjectData.getOneSubjectName());
            eduSubjectService.save(existoneSubject);
        }
        //判断二级分类是否重复
        EduSubject existtwoSubject = this.existTwoSubhect(eduSubjectService, subjectData.getTwoSubjectName(), existoneSubject.getId());
        if (existtwoSubject == null) {
            existtwoSubject = new EduSubject();
            existtwoSubject.setParentId(existoneSubject.getId());
            existtwoSubject.setTitle(subjectData.getTwoSubjectName());
            eduSubjectService.save(existtwoSubject);
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.print("读完了------------------》");
    }

    //判断一级分类不能重复
    public EduSubject existOneSubhect(EduSubjectService eduSubjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        EduSubject one = eduSubjectService.getOne(wrapper);
        return one;
    }

    //判断二级分类不能重复
    public EduSubject existTwoSubhect(EduSubjectService eduSubjectService, String name, String id) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", id);
        EduSubject tow = eduSubjectService.getOne(wrapper);
        return tow;
    }
}
