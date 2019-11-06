package com.provider.cloudprovider.feign.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.example.cloudcommons.resp.Code;
import com.example.cloudcommons.resp.ResponseMsg;
import com.provider.cloudprovider.feign.UserProductFeign;
import org.springframework.stereotype.Component;

/**
 * @Author: carter
 * @Date: 2019/11/6 21:42
 * @Version 1.0
 */
@Component
public class UserProductHystrix implements UserProductFeign {

    /**
     * 扣减库存熔断器
     * @param data
     * @return
     */
    @Override
    public ResponseMsg deductionInventory(JSONObject data) {
        return new ResponseMsg(Code.FAIL,null,"调用cloud-provider-2服务失败！");
    }
}
