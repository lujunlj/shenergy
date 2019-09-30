package com.sgnbs.energy;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IDEA
 * author: lujun
 * Date:2019/9/27
 * Time:17:14
 */
@SpringBootApplication
@EnableDiscoveryClient
@DubboComponentScan
@EnableSwagger2
@Slf4j
public class SystemApp {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SystemApp.class, args);
        Environment env = configurableApplicationContext.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path","");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Jsepc-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
//              "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
//              "Doc: \t\thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }
}
