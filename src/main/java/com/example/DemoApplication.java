package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


import java.util.concurrent.CountDownLatch;

@Configuration
@ComponentScan
@MapperScan(basePackages = {"com.example.mapper"})
@EnableAutoConfiguration
@SpringBootApplication
@ImportResource({"classpath:provider.xml"})
public class DemoApplication {


    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    public static void main(String[] args) throws InterruptedException {
//        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        ApplicationContext ctx = new SpringApplicationBuilder().sources(DemoApplication.class)
                .web(false)
                .run(args);
//        logger.info("项目启动成功");
        CountDownLatch countDownLatch = (CountDownLatch) ctx.getBean(CountDownLatch.class.getName());
        countDownLatch.await();
    }


}
