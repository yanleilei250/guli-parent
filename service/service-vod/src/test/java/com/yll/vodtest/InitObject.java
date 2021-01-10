package com.yll.vodtest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author 颜起名
 * @create date 2021-01-07-23:32
 */

public class InitObject {
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) throws Exception{
        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

}
