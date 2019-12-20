package com.xmu.wowoto.delay.controller;

import com.xmu.wowoto.delay.service.PicService;
import com.xmu.wowoto.delay.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MedalWill
 * @date 2019/12/20 10:55
 */

@RestController
@RequestMapping("")
public class PicController {
    @Autowired
    PicService picService;

    @PostMapping("/pics")
    public Object uploadToPost(@RequestParam("file") MultipartFile file)
    {
        String name=picService.upload(file);
        System.out.println(name);
        return ResponseUtil.ok(name);
    }

}
