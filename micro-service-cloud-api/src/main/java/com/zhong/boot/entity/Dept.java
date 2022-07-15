package com.zhong.boot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String dbSource;
}

