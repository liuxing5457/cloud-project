package com.provider.cloudprovider.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.cloudcommons.resp.Code;
import com.example.cloudcommons.resp.ResponseMsg;
import com.provider.cloudprovider.service.IUserProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 扣减库存
 *
 * @Author: carter
 * @Date: 2019/11/6 20:43
 * @Version 1.0
 */

@RestController
@RequestMapping("/deductionInventory")
public class DeductionInventoryController {

    private Logger logger = LoggerFactory.getLogger(DeductionInventoryController.class);

    @Resource
    private IUserProductService userProductService;

    /**
     * 扣减库存实现
     *
     * @return
     */
    @PostMapping("/deduction")
    public ResponseMsg deductionInventory(@RequestBody JSONObject data) {
        try {
            /**商品id*/
            Integer productId = data.getInteger("id");
            /**用户id*/
            Integer userId = data.getInteger("userId");
            /**扣减的数量*/
            Integer num = data.getInteger("num");
            if (productId == null || num == null) {
                return new ResponseMsg(Code.UNKNOW, null, "商品id和扣减的数量不能为空！");
            }
            Integer fig = userProductService.deductionInventory(productId, userId, num);
            if (fig > 0) {
                return new ResponseMsg(Code.SUCCESS, fig, "扣减库存成功！");
            }
            return new ResponseMsg(Code.FAIL, fig, "扣减库存失败！");
        } catch (Exception e) {
            logger.info("扣减库存失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "扣减库存失败！" + e.getMessage());
        }
    }

}
