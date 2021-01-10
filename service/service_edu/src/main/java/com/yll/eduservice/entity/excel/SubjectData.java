package com.yll.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author 颜起名
 * @create date 2020-08-05-21:13
 */
public class SubjectData {
    @ExcelProperty(index = 0)
    private String oneSubjectName;
    @ExcelProperty(index = 1)
    private String twoSubjectName;


    public String getOneSubjectName() {
        return oneSubjectName;
    }

    public void setOneSubjectName(String oneSubjectName) {
        this.oneSubjectName = oneSubjectName;
    }

    public String getTwoSubjectName() {
        return twoSubjectName;
    }

    public void setTwoSubjectName(String twoeSubjectName) {
        this.twoSubjectName = twoeSubjectName;
    }

    public SubjectData() {
    }

    public SubjectData(String oneSubjectName, String twoSubjectName) {
        this.oneSubjectName = oneSubjectName;
        this.twoSubjectName = twoSubjectName;
    }
}
