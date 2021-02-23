package com.qg.mysqlsharding.config;

import com.qg.mysqlsharding.util.BeanDefinitionRegistrarUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(BeanDefinitionRegistrarUtil.class)
@Configuration
public class ShardingConfig {
}
