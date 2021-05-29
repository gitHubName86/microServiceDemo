package com.fzp.provider.service.impl;

import com.fzp.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fzp.common.redisCfg.RedisClient;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private RedisClient redisClient;

    @Override
    public String sayHelloConsumer(String str) {
        System.out.println("provider str : " + str);
        return str;
    }

    /**
     * 设置 key, value 存入 redis
     *
     * @param key
     * @param value
     * @param time
     *
     * */
    @Override
    public void setValue(String key, Object value, long time) {
        redisClient.set(key, value, time);
    }

    /**
     * 根据 key 获取 value
     * @param key
     * @return
     * */
    @Override
    public String getValue(String key) {
        return redisClient.get(key) == null ? "redis key time out" : redisClient.get(key);
    }
}
