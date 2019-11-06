package com.provider.cloudprovider.feign;


import com.alibaba.fastjson.JSONObject;
import com.example.cloudcommons.resp.ResponseMsg;
import com.provider.cloudprovider.feign.hystrix.UserProductHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @Author: carter
 * @Date: 2019/11/6 20:29
 * @Version 1.0
 */

@FeignClient(name = "cloud-provider-2", fallback = UserProductHystrix.class)
public interface UserProductFeign {


    @PostMapping("/deductionInventory/deduction")
    ResponseMsg deductionInventory(@RequestBody JSONObject data);

}
