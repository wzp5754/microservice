package com.microservice.consumer.controller;

import com.microservice.entity.DeptInfo;
import com.microservice.consumer.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    private final String DEPT_INSTANCE = "MICROSERVICE-DEPT";

    @GetMapping(value = "/get/{id}")
    public DeptInfo get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @GetMapping(value = "/list")
    public List<DeptInfo> list(){
        return deptService.list();
    }

    @PostMapping(value = "/add")
    @HystrixCommand(commandKey = "",fallbackMethod = "")
    public boolean add(DeptInfo deptInfo){
        return deptService.add(deptInfo);
    }
    @PutMapping(value = "/update")
    public boolean update(DeptInfo deptInfo){
        return deptService.update(deptInfo);
    }
    @DeleteMapping(value = "/del/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return deptService.delete(id);
    }

    @GetMapping(value = "/disconvery")
    public Object disconvery(){
        List<String> services = client.getServices();
        List<ServiceInstance> lists = client.getInstances(DEPT_INSTANCE);
        for(ServiceInstance instance : lists){
            System.out.println(instance.getUri());
        }
        return this.client;
    }



}
