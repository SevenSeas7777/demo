package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept1 {
    private Integer deptno;
    private String dname;
    private String loc;
    private Integer count;
}
