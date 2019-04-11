package com.microservice.consumer.dao;

import com.microservice.entity.DeptInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface DeptDao {

    public boolean add(DeptInfo dept);

    public boolean update(DeptInfo dept);

    public DeptInfo findById(@Param("deptno") Long deptno);

    public List<DeptInfo> findAll();

    public boolean delete(@Param("deptno") Long deptno);
}
