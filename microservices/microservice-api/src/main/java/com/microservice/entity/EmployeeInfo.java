package com.microservice.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo implements Serializable {
    private long empno;

    private String name;

    private Data signdate;
}
