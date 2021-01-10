package com.yll.eduservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yll.eduservice.entity.EduChapter;
import com.yll.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-08-17
 */
public interface EduVideoService extends IService<EduVideo> {

    boolean removeVideoById(String videoId);
}
