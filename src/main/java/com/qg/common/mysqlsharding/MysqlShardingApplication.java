package com.qg.common.mysqlsharding;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.qg.common.mysqlsharding.mapper")
@NacosPropertySource(dataId = "mysql-sharding.yaml", autoRefreshed = true)
public class MysqlShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlShardingApplication.class, args);
    }
}
