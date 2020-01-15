package com.hdj.baseproject.jdbc;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * <p>标题: </p>
 * <p>描述: </p>
 *
 * <p>版权: 税友软件集团股份有限公司</p>
 * <p>创建时间: 2019-6-6</p>
 * <p>作者：liwenj</p>
 */
@MapperScan(basePackages = {"com.hdj.baseproject.mapper"},
        sqlSessionTemplateRef = "ntdapDaupSqlSessionTemplate",
        annotationClass = Repository.class)
@Configuration
public class TestSqlSessionFactory {

    private String mapperLocations = "classpath*:mapper/*Mapper.xml";

    @Value("${spring.mybatis.conf.file}")
    private String mybatisConfigFile;

    @Resource(name = "testdb")
    private DataSource dataSource;

    @Bean(name = "ntdapDaupSqlSessionFactory")
    public SqlSessionFactory daupSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(mybatisConfigFile));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "ntdapDaupSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("ntdapDaupSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
