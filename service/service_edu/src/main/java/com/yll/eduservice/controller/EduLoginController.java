package com.yll.eduservice.controller;

import com.yll.commonutils.R;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author 颜起名
 * @create date 2020-07-28-0:27
 */
@CrossOrigin
@Api(description = "登录")
@RestController
@RequestMapping("/eduservice/user")
public class EduLoginController {
    @PostMapping("login")
    public R login() {
        System.out.println("执行了login方法");
        HashMap<String, String> map = new HashMap<>();
        map.put("tonke", "颜磊");
        return R.ok().data("data", map);
    }

    @GetMapping("info")
    public R info() {
        //roles, name, avatar
//        HashMap<String, String> map = new HashMap<>();
//        map.put("roles","颜磊");
//        map.put("name","admin");
//        map.put("avatar","");
        System.out.println("执行了info方法");
        return R.ok().data("roles", "颜磊").data("name", "颜磊").data("avatar", "https://guli-yanlei.oss-cn-hangzhou.aliyuncs.com/2020/08/02/6dd280ee3e474a9784bea00b6e13f42e01.jpg");
    }
}
