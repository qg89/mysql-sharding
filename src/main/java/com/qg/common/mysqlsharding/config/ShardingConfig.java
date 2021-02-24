package com.qg.common.mysqlsharding.config;

import com.qg.common.mysqlsharding.util.BeanDefinitionRegistrarUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(BeanDefinitionRegistrarUtil.class)
@Configuration
public class ShardingConfig {
}
