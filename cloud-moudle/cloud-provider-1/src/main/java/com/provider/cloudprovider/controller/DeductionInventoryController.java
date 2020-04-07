package com.provider.cloudprovider.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.cloudcommons.resp.Code;
import com.example.cloudcommons.resp.ResponseMsg;
import com.provider.cloudprovider.feign.UserProductFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 扣减库存控制层  feign调用
 *
 * @Author: carter
 * @Date: 2019/11/6 20:22
 * @Version 1.0
 */
@RestController
@RequestMapping("/deductionInventory")
public class DeductionInventoryController {


    private Logger logger = LoggerFactory.getLogger(DeductionInventoryController.class);

    @Resource
    private UserProductFeign userProductFeign;

    /**
     * 扣减库存 feign调用
     * @param data
     * @return
     */
    @PostMapping("/deduction")
    public ResponseMsg deductionInventory(@RequestBody JSONObject data) {
        try{
            ResponseMsg msg = userProductFeign.deductionInventory(data);
            return msg;
        }catch (Exception e){
            logger.info("扣减库存失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "扣减库存失败！" + e.getMessage());
        }
    }

}
