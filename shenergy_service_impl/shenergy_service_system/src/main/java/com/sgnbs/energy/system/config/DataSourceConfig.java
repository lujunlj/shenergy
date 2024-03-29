package com.sgnbs.energy.system.config;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.beans.PropertyVetoException;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriverName;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUserName;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;
    @Value("${spring.datasource.hikari.auto-commit}")
    private boolean autoCommit;

    @Bean(name="dataSource")
    public HikariDataSource createDataSource() throws PropertyVetoException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(jdbcDriverName);
        dataSource.setUsername(jdbcUserName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setPassword(jdbcPassword);
        // 关闭连接后不自动提交
        dataSource.setAutoCommit(autoCommit);
        return dataSource;
    }


}