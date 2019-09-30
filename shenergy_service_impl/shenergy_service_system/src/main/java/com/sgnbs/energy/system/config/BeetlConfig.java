package com.sgnbs.energy.system.config;

import com.sgnbs.energy.core.common.utils.IdGen;
import org.beetl.sql.core.IDAutoGen;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.SQLManagerBuilder;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Random;

/**
 * Created with IDEA
 * author: lujun
 * Date:2019/9/29
 * Time:12:04
 */
@Configuration
public class BeetlConfig {

    @Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

    @Bean
    public BeetlSqlDataSource beetlSqlDataSource(){
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(dataSource);
        return source;
    }

}
