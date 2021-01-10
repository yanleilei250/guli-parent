package com.yll.vodservice.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 颜起名
 * @create date 2021-01-08-23:41
 */
public interface VodService {
    //上传视频到阿里云
    String uploadVoid(MultipartFile file);
}
