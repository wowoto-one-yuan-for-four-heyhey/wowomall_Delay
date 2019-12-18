package com.xmu.wowoto.wowomall.delay.controller;

import com.xmu.wowoto.wowomall.delay.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MedalWill
 * @date 2019/12/17 21:16
 */
@RestController
@RequestMapping("")
public class DelayController {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("test")
    public void test(){
        Set<String> set=new HashSet<>();
        set.add("100001");
        set.add("100002");
        set.add("100003");
        set.add("100006");
        System.out.println(redisUtil.hasKey("test"));
        redisUtil.addToSet("test",set);
        Set<String> ret=redisUtil.getSet("test");
        for(String str : ret)
        {System.out.println(str);}

        redisUtil.addToSet("test",set);
        redisUtil.addToSet("test1",set);
        redisUtil.addToSet("test2",set);
        redisUtil.addToSet("test3",set);
        redisUtil.setDelay("test1",60*1000);
        redisUtil.setDelay("test2",60*5*1000);
        redisUtil.setDelay("test3",60*30*1000);

    }

}
