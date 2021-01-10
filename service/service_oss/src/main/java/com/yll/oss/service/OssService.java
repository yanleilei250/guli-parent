package com.yll.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 颜起名
 * @create date 2020-08-02-15:47
 */

public interface OssService {
    String upload(MultipartFile file);
}
