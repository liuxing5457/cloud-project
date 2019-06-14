package com.provider.cloudprovider.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: carter
 * @Date: 2019/6/13 9:16
 * @Version 1.0
 */
@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping("testService")
    public String testService(@RequestBody JSONObject data) {
        String name = data.getString("name");
        return "你好" + name+",cloud-provider-1";
    }

}
