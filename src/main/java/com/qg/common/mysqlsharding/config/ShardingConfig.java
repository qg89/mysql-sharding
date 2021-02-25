package com.qg.common.mysqlsharding.config;

import com.qg.common.mysqlsharding.utils.BeanDefinitionRegistrarUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(BeanDefinitionRegistrarUtils.class)
@Configuration
public class ShardingConfig {
}
