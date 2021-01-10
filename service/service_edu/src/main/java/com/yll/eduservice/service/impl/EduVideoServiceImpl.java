package com.yll.eduservice.service.impl;

import com.yll.eduservice.entity.EduVideo;
import com.yll.eduservice.mapper.EduVideoMapper;
import com.yll.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-08-17
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Override
    public boolean removeVideoById(String videoId) {

        return false;
    }
}
