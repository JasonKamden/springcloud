package com.zhong.boot.controller;

import com.zhong.boot.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "dept/hystrix/ok/{id}")
    public String deptInfo_Timeout(@PathVariable("id") Integer id) {
        String result = deptService.deptInfo_TimeOut(id);
        log.info("端口号：" + serverPort + ", result:" + result);
        return result + ",  端口号:" + serverPort;
    }
}

