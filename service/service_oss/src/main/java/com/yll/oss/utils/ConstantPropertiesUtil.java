package com.yll.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.naming.spi.InitialContextFactory;

/**
 * @author 颜起名
 * @create date 2020-08-02-15:27
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.accessKeyId}")
    private String keyId;
    @Value("${aliyun.oss.file.accessKeySecret}")
    private String keySecret;
    @Value("${aliyun.oss.file.bucketName}")
    private String bucketName;
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}
