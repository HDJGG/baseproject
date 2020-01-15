package com.hdj.baseproject.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * <p>标题: 数据源daup配置</p>
 * <p>描述: </p>
 * <p>
 * <p>版权: 税友软件集团股份有限公司</p>
 * <p>创建时间: 2018/7/27</p>
 * <p>作者：liwenj</p>
 */
@Configuration
@Slf4j
public class TestdbSourceConf {

    /*定义数据源*/
    @ConfigurationProperties(prefix = "spring.datasource.test")
    @Bean(name = "testdb")
    public DataSource daupDataSource() {
        if (log.isInfoEnabled()) {
            log.info("[config.datasource]正在初始化值库结果数据源{spring.datasource.test.*}");
        }
        return new DruidDataSource();
    }

}
