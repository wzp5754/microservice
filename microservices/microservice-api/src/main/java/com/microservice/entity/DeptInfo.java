package com.microservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DeptInfo implements Serializable {

    private long deptno;

    private String deptname;

    private String db_source;


}
