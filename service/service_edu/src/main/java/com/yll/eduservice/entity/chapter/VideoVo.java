package com.yll.eduservice.entity.chapter;

/**
 * @author 颜起名
 * @create date 2020-09-02-21:43
 */
public class VideoVo {
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

    public VideoVo(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public VideoVo() {
    }

    @Override
    public String toString() {
        return "VideoVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
