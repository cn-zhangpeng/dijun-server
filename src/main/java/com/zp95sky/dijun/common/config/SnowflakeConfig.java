package com.zp95sky.dijun.common.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 山海紫穹
 * @date 2021年07月20日 14:43
 */
@Configuration
public class SnowflakeConfig {

    @Value("${id-worker.worker-id}")
    private long workerId;

    @Value("${id-worker.data-center-id}")
    private long dataCenterId;

    @Bean
    public Snowflake snowflake() {
        return IdUtil.getSnowflake(workerId, dataCenterId);
    }

}
