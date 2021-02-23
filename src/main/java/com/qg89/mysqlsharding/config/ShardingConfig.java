package com.qg89.mysqlsharding.config;

import com.qg89.mysqlsharding.util.BeanDefinitionRegistrarUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(BeanDefinitionRegistrarUtil.class)
@Configuration
public class ShardingConfig {
}
