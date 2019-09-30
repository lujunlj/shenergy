package com.sgnbs.energy.system.config;

import com.sgnbs.energy.core.common.utils.IdGen;
import org.beetl.sql.core.IDAutoGen;
import org.beetl.sql.core.SQLManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)   //通过order值的大小来决定启动的顺序
public class UuidAnnotation implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        SQLManager.getSQLManagerByName("mysql").addIdAutonGen("uuid", new IDAutoGen(){
            @Override
            public Object nextID(String params) {
                return IdGen.uuid();
            }
        });
    }

}