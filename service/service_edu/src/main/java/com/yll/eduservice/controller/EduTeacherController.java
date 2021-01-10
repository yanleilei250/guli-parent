package com.yll.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yll.commonutils.R;
import com.yll.eduservice.entity.EduTeacher;
import com.yll.eduservice.entity.vo.EduTeacherQuery;
import com.yll.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author testjava
 * @since 2020-07-24
 */
@RestController
@CrossOrigin
@Api(description = "讲师管理")
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService service;

    @GetMapping("findAll")
    @ApiOperation(value = "所有讲师列表")
    public R findAll() {
        List<EduTeacher> list = service.list(null);
        return R.ok().data("items", list);
    }


    @DeleteMapping("removeById/{id}")
    @ApiOperation(value = "根据ID删除讲师")
    public R removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        return service.removeById(id) ? R.ok() : R.error();
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("pageList/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        service.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();//数据
        long total = pageParam.getTotal();//总记录数
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "分页条件讲师列表")
    @PostMapping("pageQuery/{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            @RequestBody EduTeacherQuery teacherQuery) {
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        service.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("items", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("addTeacher")
    public R addTeacher(
            @RequestBody EduTeacher teacher) {
        return service.save(teacher) ? R.ok() : R.error();
    }

    @GetMapping("saveById/{id}")
    @ApiOperation(value = "根据ID查询讲师")
    public R saveById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        EduTeacher eduTeacher = service.getById(id);
        return R.ok().data("eduTeacher", eduTeacher);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PostMapping("upTeacher")
    public R upTeacher(
            @RequestBody EduTeacher teacher) {
        return service.updateById(teacher) ? R.ok() : R.error();
    }
}