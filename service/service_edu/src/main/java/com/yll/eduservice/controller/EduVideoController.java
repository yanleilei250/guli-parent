package com.yll.eduservice.controller;


import com.sun.xml.bind.v2.TODO;
import com.yll.commonutils.R;
import com.yll.eduservice.entity.EduVideo;
import com.yll.eduservice.service.EduVideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-08-17
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService videoService;

    //添加小节 TODO
    @ApiOperation(value = "添加小节")
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        boolean save = videoService.save(eduVideo);
        return save ? R.ok() : R.error();
    }

    //修改小节 TODO
    @ApiOperation(value = "修改小节")
    @PostMapping("upDataVideo")
    public R upDataVideo(@RequestBody EduVideo eduVideo) {
        boolean b = videoService.updateById(eduVideo);
        return b ? R.ok() : R.error();
    }

    //删除小节 TODO
    @ApiOperation(value = "根据ID删除小节")
    @DeleteMapping("deleteVideo/{videoId}")
    public R deleteVideo(@PathVariable String videoId) {
        //boolean b = videoService.removeVideoById(videoId); TODO
        //需要完善
        boolean b = videoService.removeById(videoId);
        return b ? R.ok() : R.error();
    }

    //查询小节 TODO
    @ApiOperation(value = "根据ID查询小节")
    @GetMapping("getVideo/{videoId}")
    public R getVideo(@PathVariable String videoId) {
        EduVideo eduVideo = videoService.getById(videoId);
        return R.ok().data("eduVideo", eduVideo);
    }


}

