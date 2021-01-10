package com.yll.oss.controller;

import com.yll.commonutils.R;
import com.yll.oss.service.Impl.OssServiceImpl;
import com.yll.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 颜起名
 * @create date 2020-08-02-15:46
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;

    @PostMapping("upload")
    public R upload(MultipartFile file) {
        String url = ossService.upload(file);
        return R.ok().data("url", url);
    }
}
