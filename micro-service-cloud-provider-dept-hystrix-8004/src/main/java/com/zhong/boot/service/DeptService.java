package com.zhong.boot.service;

public interface DeptService {
    // hystrix 熔断器示例 ok
    public String deptInfo(Integer id);

    //hystrix 熔断器超时案例
    public String deptInfo_TimeOut(Integer id);
}
