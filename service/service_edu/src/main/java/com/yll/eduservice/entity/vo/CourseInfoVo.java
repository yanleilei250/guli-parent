package com.yll.eduservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 颜起名
 * @create date 2020-08-17-22:41
 */

@ApiModel(value = "课程基本信息", description = "编辑课程基本信息的表单对象")
public class CourseInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程ID")
    private String id;

    public String getSubjectParentId() {
        return subjectParentId;
    }

    public void setSubjectParentId(String subjectParentId) {
        this.subjectParentId = subjectParentId;
    }

    @ApiModelProperty(value = "课程专业父级ID")
    private String subjectParentId;

    @ApiModelProperty(value = "课程讲师ID")
    private String teacherId;

    @ApiModelProperty(value = "课程专业ID")
    private String subjectId;

    @ApiModelProperty(value = "课程标题")
    private String title;

    @ApiModelProperty(value = "课程销售价格，设置为0则可免费观看")
    private BigDecimal price;

    @ApiModelProperty(value = "总课时")
    private Integer lessonNum;

    @ApiModelProperty(value = "课程封面图片路径")
    private String cover;

    @ApiModelProperty(value = "课程简介")
    private String description;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseInfoVo() {
    }

    public CourseInfoVo(String id, String teacherId, String subjectId, String title, BigDecimal price, Integer lessonNum, String cover, String description, String subjectParentId) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectParentId = subjectParentId;
        this.subjectId = subjectId;
        this.title = title;
        this.price = price;
        this.lessonNum = lessonNum;
        this.cover = cover;
        this.description = description;
    }
}
