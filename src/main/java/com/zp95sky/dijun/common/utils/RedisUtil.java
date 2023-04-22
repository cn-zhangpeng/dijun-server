package com.zp95sky.dijun.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 * @author zhangpeng
 */
@Slf4j
public class RedisUtil {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    /**
     * 设置键值
     */
    @SneakyThrows
    public <T> void set(String key, T value) {
        String valueStr = objectMapper.writeValueAsString(value);
        redisTemplate.opsForValue().set(key, valueStr);
    }

    /**
     * 设置键值并设置有效时间
     */
    @SneakyThrows
    public <T> void set(String key, T value, long timeout, TimeUnit timeUnit) {
        String valueStr = objectMapper.writeValueAsString(value);
        redisTemplate.opsForValue().set(key, valueStr, timeout, timeUnit);
    }

    /**
     * 删除键
     */
    public Boolean del(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 获取键值对
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * key 是否存在
     */
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * key 的失效时间
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

}
