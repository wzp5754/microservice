package com.microservice.consumer.controller;

import com.microservice.entity.DeptInfo;
import com.microservice.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    //private static final String REST_URL_PREFIX = "http://127.0.0.1:8001/";
   // private static final String REST_URL_PREFIX = "http://MICROSERVICE-DEPT/";
    @Autowired(required = false)
    private DeptClientService deptClientService;


    @GetMapping(value = "/get/{id}")
    public DeptInfo get(@PathVariable("id") Long id){
        return deptClientService.get(id);
    }
    @GetMapping(value = "/list")
    public List<DeptInfo> list(){
        return deptClientService.list();
    }
    @PostMapping(value = "/add")
    public boolean add(DeptInfo deptInfo){
        return deptClientService.add(deptInfo);
    }
    @PutMapping(value = "/update")
    public boolean update(DeptInfo deptInfo){
        return deptClientService.update(deptInfo);
    }

    @DeleteMapping(value = "/del/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return deptClientService.delete(id);
    }

}
