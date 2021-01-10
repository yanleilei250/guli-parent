package com.yll.vodservice.controller;

import com.yll.commonutils.R;
import com.yll.vodservice.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 颜起名
 * @create date 2021-01-08-23:36
 */
@CrossOrigin
@RequestMapping("/eduvod/filevod")
@RestController
@Api(description = "视频上传")
public class VodController {
    @Autowired
    private VodService vodService;
    //上传到aliyun
    @PostMapping("uploadAliyunVoid")
    @ApiOperation(value = "上传视频文件返回视频ID")
    public R uploadAliyunVoid(@ApiParam(name = "file", value = "文件", required = true)
                                  @RequestParam("file") MultipartFile file){
     String videoId =  vodService.uploadVoid(file);
        return R.ok().data("videoId",videoId);
    }
}
