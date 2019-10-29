package com.jerry.springboot_junit4.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;

import java.util.UUID;

@Slf4j
public abstract class BaseController {
    public ModelMap getModelMap(String status,Object data,String msg){
        ModelMap modelMap=new ModelMap();
        modelMap.put("status",status);
        modelMap.put("data",data);
        modelMap.put("msg",msg);
        return modelMap;
    }
    public String getUuid()
    {
        String uuid= UUID.randomUUID().toString();
        uuid=uuid.replace("-","");
        return uuid;
    }

}
