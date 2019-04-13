package com.microservice.consumer.controller;

import com.microservice.entity.DeptInfo;
import com.microservice.consumer.service.DeptClientService;
import com.microservice.utils.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    //private static final String REST_URL_PREFIX = "http://127.0.0.1:8001/";
   // private static final String REST_URL_PREFIX = "http://MICROSERVICE-DEPT/";
    @Autowired(required = false)
    private DeptClientService deptClientService;


    @GetMapping(value = "/get/{id}")
    public RetResult get(@PathVariable("id") Long id){
        DeptInfo deptInfo = deptClientService.get(id);
        if (null == deptInfo){
            return RetResult.error("未查到数据！");
        }
        return RetResult.success(deptInfo);

    }
    @GetMapping(value = "/list")
    public RetResult list(){
        List<DeptInfo> list = deptClientService.list();
        if (null == list){
            return RetResult.error("未查到数据！");
        }
        return RetResult.success(list);
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
