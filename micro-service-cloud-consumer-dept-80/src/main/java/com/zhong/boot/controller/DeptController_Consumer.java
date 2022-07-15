package com.zhong.boot.controller;

import com.zhong.boot.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {
    //直接调用服务，没有用到spring cloud
    //private static final String REST_URL_PROVIDER_PREFIX = "http://localhost:8001";

    //microservicecloudproviderdept
    // 使用注册到Spring Cloud Eureka服务注册中的服务，即application.name
    private static final String REST_URL_PROVIDER_PREFIX = "http://MICROSERVICECLOUDPROVIDERDEPT";

    // //RestTemplate 是一种简单便捷的访问 restful 服务模板类，是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，提供了多种便捷访问远程 HTTP 服务的方法
    @Autowired
    private RestTemplate restTemplate;


    //获取指定部门信息
    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/get/" + id, Dept.class);
    }

    //获取部门列表
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/list/", List.class);
    }
}
