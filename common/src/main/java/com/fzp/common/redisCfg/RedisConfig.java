package com.fzp.common.redisCfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 主要是修改其默认的序列化方式，默认序列化方式为JdkSerializationRedisSerializer，
 * 编码格式为ISO-8859-1，值在传递过程中会出现乱码，将其修改为StringRedisSerializer，
 * 其编码方式为UTF-8，可解决乱码问题。
 * */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //设置 value 的序列化规则和 key 的序列化规则
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return  redisTemplate;
    }
}
