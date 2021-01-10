package com.yll.eduservice.controller;


import com.yll.commonutils.R;
import com.yll.eduservice.entity.subject.OneSubject;
import com.yll.eduservice.service.EduSubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    EduSubjectService eduSubjectService;

    @PostMapping("addSubject")
    @ApiOperation(value = "Excel批量导入")
    public R addSubject(MultipartFile file) {
        eduSubjectService.saveSubject(file, eduSubjectService);
        return R.ok();
    }

    //课程分类列表（树形）
    @GetMapping("getAllSubject")
    @ApiOperation(value = "课程分类列表（树形）")
    public R getAllSubjet() {
        List<OneSubject> list = eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list", list);
    }

}

