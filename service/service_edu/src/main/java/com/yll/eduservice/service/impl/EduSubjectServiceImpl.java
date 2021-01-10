package com.yll.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yll.eduservice.entity.EduSubject;
import com.yll.eduservice.entity.excel.SubjectData;
import com.yll.eduservice.entity.subject.OneSubject;
import com.yll.eduservice.entity.subject.TwoSubject;
import com.yll.eduservice.listener.SubjectExcelListener;
import com.yll.eduservice.mapper.EduSubjectMapper;
import com.yll.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-08-05
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("实现类错误");
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {

        //查询一级
        QueryWrapper<EduSubject> qw1 = new QueryWrapper<>();
        qw1.eq("parent_id", "0");
        List<EduSubject> eduSubjects1 = baseMapper.selectList(qw1);
        //查询二级
        QueryWrapper<EduSubject> qw2 = new QueryWrapper<>();
        qw2.ne("parent_id", "0");
        List<EduSubject> eduSubjects2 = baseMapper.selectList(qw2);
        //封装一级
        List<OneSubject> finalSubjectList = new ArrayList<>();
        for (int y = 0; y < eduSubjects1.size(); y++) {
            EduSubject subject = eduSubjects1.get(y);
            OneSubject oneSubject = new OneSubject();
            oneSubject.setId(subject.getId());
            oneSubject.setTitle(subject.getTitle());
            finalSubjectList.add(oneSubject);

            //封装二级
            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            for (int i = 0; i < eduSubjects2.size(); i++) {
                EduSubject eduSubject = eduSubjects2.get(i);
                if ((eduSubject.getParentId()).equals(subject.getId())) {
                    TwoSubject twoSubject = new TwoSubject();
                    twoSubject.setId(eduSubject.getId());
                    twoSubject.setTitle(eduSubject.getTitle());
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoFinalSubjectList);
        }
        return finalSubjectList;
    }
}
