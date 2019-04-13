package com.microservice.consumer.service;

import com.microservice.entity.DeptInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(value = "MICROSERVICE-DEPT")
public interface DeptClientService {

    @GetMapping(value = "/dept/get/{id}")
    public DeptInfo get(@PathVariable("id") Long id);
    @GetMapping(value = "/dept/list")
    public List<DeptInfo> list();
    @PostMapping(value = "/dept/add")
    public boolean add(DeptInfo deptInfo);
    @PutMapping(value = "/dept/update")
    public boolean update(DeptInfo deptInfo);

    @DeleteMapping(value = "/dept/del/{id}")
    public boolean delete(@PathVariable("id") Long id);

}
