package com.yll.eduservice.entity.subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 颜起名
 * @create date 2020-08-15-21:16
 */
public class OneSubject {
    private String id;
    private String title;
    private List<TwoSubject> children = new ArrayList<>();

    public List<TwoSubject> getChildren() {
        return children;
    }

    public void setChildren(List<TwoSubject> children) {
        this.children = children;
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

    public OneSubject() {
    }

    public OneSubject(String id, String title) {
        this.id = id;
        this.title = title;
    }
}
