package com.microservice.consumer.controller;

import com.microservice.entity.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    //private static final String REST_URL_PREFIX = "http://127.0.0.1:8001/";
    private static final String REST_URL_PREFIX = "http://MICROSERVICE-DEPT/";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/get/{id}")
    public DeptInfo get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"dept/get/"+id,DeptInfo.class);
    }
    @GetMapping(value = "/list")
    public List<DeptInfo> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"dept/list",List.class);
    }
    @PostMapping(value = "/add")
    public boolean add(DeptInfo deptInfo){
        return restTemplate.postForObject(REST_URL_PREFIX+"dept/add",deptInfo,Boolean.class);
    }
    @PutMapping(value = "/update")
    public boolean update(DeptInfo deptInfo){
        return restTemplate.postForObject(REST_URL_PREFIX+"dept/update",deptInfo,Boolean.class);
    }

    @DeleteMapping(value = "/del/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return restTemplate.postForObject(REST_URL_PREFIX+"del/"+id,null,Boolean.class);
    }

}
