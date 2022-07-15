package com.zhong.boot.service;

import com.zhong.boot.entity.Dept;

import java.util.List;

public interface DeptService {
    Dept get(Integer deptNo);

    List<Dept> selectAll();

}
