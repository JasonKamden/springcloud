package com.zhong.boot.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhong.boot.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("deptService")
public class DeptServiceImpl implements DeptService {


    @Override
    public String deptInfo(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "  deptInfo_Ok,id:   " + id;
    }

    @HystrixCommand(fallbackMethod = "dept_TimeOutHandler",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeout.timeoutInMilliseconds",value = "5000")

    })

    @Override
    public String deptInfo_TimeOut(Integer id) {
        int outTime = 6;
        try {
            TimeUnit.SECONDS.sleep(outTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池：" + Thread.currentThread().getName() + "  deptInfo_Timeout,id:   " + id + "  耗时: " + outTime;
    }

    public String dept_TimeOutHandler(Integer id) {
        return "JasonKamden提醒您，系统繁忙请稍后再试！" + "线程池：" + Thread.currentThread().getName() + "deptInfo_TimeOut,id :" + id;
    }
}
