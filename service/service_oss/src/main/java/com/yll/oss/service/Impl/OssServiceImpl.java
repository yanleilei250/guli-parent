package com.yll.oss.service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.yll.oss.service.OssService;
import com.yll.oss.utils.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author 颜起名
 * @create date 2020-08-02-15:48
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String upload(MultipartFile file) {
        String endPoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
//        String endPoint ="oss-cn-hangzhou.aliyuncs.com";
//        String accessKeyId ="LTAI4FyBXH3UpauDnJDLKkBV";
//        String accessKeySecret ="IQ1SCunfbH6PVYk1dakbuIiR2WyOm6";
//        String bucketName ="guli-yanlei";
        System.out.println(endPoint + accessKeyId + accessKeySecret + bucketName);
        // 创建OSSClient实例。
// 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
        try {
            OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            String s = new DateTime().toString("yyyy/MM/dd");
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName = s + "/" + uuid + filename;
            ossClient.putObject(bucketName, fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            String url = "https://" + bucketName + "." + endPoint + "/" + fileName;
            return url;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
