package com.fzp.common.redisCfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.fzp.common.constants.Constants;

import java.util.concurrent.TimeUnit;

/**
 * 两个简单的设置key与value和通过key获取value的方法
 * */
@Component
public class RedisClient {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置指定 key 的值
     *
     * @param key 值
     * @param value 值
     * @param time 时间（秒） time 要大于 0 ，如果 time 小于等于0 将设置无限期
     * @return true 成功， false 失败
     * */
    public boolean set(String key, Object value, long time) {
        try {
            if (time == Constants.CACHE_EXP_FOREVER) {
                redisTemplate.opsForValue().set(key, value);
            } else {
               redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取指定 key 的值
     *
     * @param key 键
     * @return 值
     * */
    public <T> T get(String key) {
        return key == null ? null : (T) redisTemplate.opsForValue().get(key);
    }
}
