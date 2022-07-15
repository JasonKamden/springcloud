package com.zhong.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //spring cloud Eureka 客户端，自动将本服务注册到Eureka server 注册中心
public class MicroServiceCloudProviderDept8001Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudProviderDept8001Application.class, args);

    }
}