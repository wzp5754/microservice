package com.microservice.service;

import com.microservice.entity.DeptInfo;

import java.util.List;

public interface DeptService {
    public boolean add(DeptInfo dept);

    public boolean update(DeptInfo dept);

    public DeptInfo get(Long deptno);

    public List<DeptInfo> list();

    public boolean delete(Long deptno);
}
