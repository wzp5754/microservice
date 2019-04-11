package com.microservice.service.impl;

import com.microservice.consumer.dao.DeptDao;
import com.microservice.entity.DeptInfo;
import com.microservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    public boolean add(DeptInfo dept) {
        return deptDao.add(dept);
    }

    public boolean update(DeptInfo dept) {
        return deptDao.update(dept);
    }

    public DeptInfo get(Long deptno) {
        return deptDao.findById(deptno);
    }

    public List<DeptInfo> list() {
        return deptDao.findAll();
    }

    @Override
    public boolean delete(Long deptno) {
        return deptDao.delete(deptno);
    }
}
