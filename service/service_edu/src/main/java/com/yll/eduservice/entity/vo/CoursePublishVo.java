package com.yll.eduservice.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 颜起名
 * @create date 2020-10-14-23:29
 */
public class CoursePublishVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String cover;//图片地址
    private String title;//课程名称
    private String description;//课程简介
    private Integer lessonNum;//课时数
    private String oneSubject;//一级标题
    private String twoSubject;//二级标题
    private String name;//教师名字

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    private String price;//只用于显示

    public CoursePublishVo() {
    }

    public CoursePublishVo(String id, String title, String description, Integer lessonNum, String oneSubject, String twoSubject, String name, String price, String cover) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lessonNum = lessonNum;
        this.oneSubject = oneSubject;
        this.twoSubject = twoSubject;
        this.name = name;
        this.price = price;
        this.cover = cover;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getOneSubject() {
        return oneSubject;
    }

    public void setOneSubject(String oneSubject) {
        this.oneSubject = oneSubject;
    }

    public String getTwoSubject() {
        return twoSubject;
    }

    public void setTwoSubject(String twoSubject) {
        this.twoSubject = twoSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "CoursePublishVo{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", lessonNum=" + lessonNum +
                ", oneSubject='" + oneSubject + '\'' +
                ", twoSubject='" + twoSubject + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
