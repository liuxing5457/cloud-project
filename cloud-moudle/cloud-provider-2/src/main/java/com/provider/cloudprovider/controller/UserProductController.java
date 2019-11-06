package com.provider.cloudprovider.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.cloudcommons.resp.Code;
import com.example.cloudcommons.resp.ResponseMsg;
import com.provider.cloudprovider.entity.UserProduct;
import com.provider.cloudprovider.service.IUserProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户商品表 前端控制器
 * </p>
 *
 * @author Carter
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/userProduct")
public class UserProductController {



    private Logger logger = LoggerFactory.getLogger(UserProductController.class);

    @Autowired
    private IUserProductService userProductService;


    /**
     * 获取用户商品信息列表
     *
     * @return
     */
    @PostMapping("/getUserProductInfoList")
    public ResponseMsg getUserInfoList() {
        try {
            List<UserProduct> list = userProductService.list();
            return new ResponseMsg(Code.SUCCESS, list, "获取用户商品信息列表成功！");
        } catch (Exception e) {
            logger.info("获取用户商品信息列表失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "获取用户商品信息列表失败！" + e.getMessage());
        }
    }

    /**
     * 获取用户商品信息
     *
     * @return
     */
    @PostMapping("/getOneUserProductInfo")
    public ResponseMsg getOneUserInfo(@RequestBody JSONObject data) {
        try {
            List<UserProduct> userProducts = userProductService.getOneUserInfo(data);
            if (!CollectionUtils.isEmpty(userProducts)) {
                return new ResponseMsg(Code.SUCCESS, userProducts, "获取用户商品信息成功!");
            }
            return new ResponseMsg(Code.UNKNOW, null, "没有找到相关信息!");
        } catch (Exception e) {
            logger.info("获取用户商品信息失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "获取用户商品信息失败！" + e.getMessage());
        }
    }


    /**
     * 插入用户商品信息列表
     *
     * @return
     */
    @PostMapping("/insertUserProductInfo")
    public ResponseMsg insertUserInfo(@RequestBody UserProduct userProduct) {
        try {
            boolean save = userProductService.insertUserInfo(userProduct);
            return new ResponseMsg(save ? Code.SUCCESS : Code.UNKNOW, save, save ? "插入用户商品信息成功" : "插入用户商品信息失败!");
        } catch (Exception e) {
            logger.info("插入用户商品信息失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "插入用户商品信息失败！" + e.getMessage());
        }
    }

    /**
     * 修改用户商品信息
     *
     * @return
     */
    @PostMapping("/updateUserProductInfo")
    public ResponseMsg updateUserInfo(@RequestBody UserProduct userProduct) {
        try {
            if(null==userProduct.getId()){
                return new ResponseMsg(Code.UNKNOW, null, "id不能为空！" );
            }
            boolean save = userProductService.updateUserInfo(userProduct);
            return new ResponseMsg(save ? Code.SUCCESS : Code.UNKNOW, save, save ? "修改用户商品信息成功" : "修改用户商品信息失败!");
        } catch (Exception e) {
            logger.info("修改用户商品信息失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "修改用户商品信息失败！" + e.getMessage());
        }
    }


    /**
     * 删除用户商品信息
     *
     * @return
     */
    @PostMapping("/deleteUserProductInfo")
    public ResponseMsg deleteUserProductInfo(@RequestBody UserProduct userProduct) {
        try {
            if(null==userProduct.getId()){
                return new ResponseMsg(Code.UNKNOW, null, "id不能为空！" );
            }
            boolean save = userProductService.deleteUserProductInfo(userProduct.getId());
            return new ResponseMsg(save ? Code.SUCCESS : Code.UNKNOW, save, save ? "删除用户商品信息成功" : "删除用户商品信息失败!");
        } catch (Exception e) {
            logger.info("删除用户商品信息失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "删除用户商品信息失败！" + e.getMessage());
        }
    }

}

