package com.provider.cloudprovider.feign;


import com.alibaba.fastjson.JSONObject;
import com.example.cloudcommons.resp.ResponseMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @Author: carter
 * @Date: 2019/11/6 20:29
 * @Version 1.0
 */

@FeignClient(name = "cloud-provider-2")
public interface UserProductFeign {


    @PostMapping("/deductionInventory/deduction")
    ResponseMsg deductionInventory(@RequestBody JSONObject data);

}
