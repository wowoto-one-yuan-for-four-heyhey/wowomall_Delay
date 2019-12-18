package com.xmu.wowoto.wowomall.delay.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author MedalWill
 * @date 2019/12/18 1:48
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean getAndSet(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     * */
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
    * 是否存在该key
    * */
    public boolean hasKey(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 添加集合
     * */
    public boolean addToSet(final String key, Set<String> value) {
        boolean result = false;
        try {
        for (String str:value) {
            redisTemplate.opsForSet().add(key, str);
            } result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 设定延时、过期时间
     * */
    public boolean setDelay(final String key,Integer delay) {
        boolean result = false;
        try {
            redisTemplate.expire(key,delay, TimeUnit.MILLISECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取集合元素
     * */
    public Set<String> getSet(final String key) {
        Set<String> result=redisTemplate.opsForSet().members(key);
        return result;
    }
}


