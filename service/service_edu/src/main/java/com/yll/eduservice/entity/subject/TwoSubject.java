package com.yll.eduservice.entity.subject;

/**
 * @author 颜起名
 * @create date 2020-08-15-21:16
 */
public class TwoSubject {
    private String id;
    private String title;

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

    public TwoSubject() {
    }

    public TwoSubject(String id, String title) {
        this.id = id;
        this.title = title;
    }
}
