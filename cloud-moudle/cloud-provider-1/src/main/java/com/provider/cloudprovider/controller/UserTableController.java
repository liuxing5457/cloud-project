package com.provider.cloudprovider.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.cloudcommons.resp.Code;
import com.example.cloudcommons.resp.ResponseMsg;
import com.provider.cloudprovider.entity.UserTable;
import com.provider.cloudprovider.service.IUserTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Carter
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/userTable")
public class UserTableController {


    private Logger logger = LoggerFactory.getLogger(UserTableController.class);

    @Autowired
    private IUserTableService userTableService;

    /**
     * 获取用户信息列表
     *
     * @return
     */
    @PostMapping("/getUserInfoList")
    public ResponseMsg getUserInfoList() {
        try {
            List<UserTable> list = userTableService.list();
            return new ResponseMsg(Code.SUCCESS, list, "获取用户信息列表成功！");
        } catch (Exception e) {
            logger.info("获取用户信息列表失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "获取用户信息列表失败！" + e.getMessage());
        }
    }

    /**
     * 获取用户信息列表
     *
     * @return
     */
    @PostMapping("/getOneUserInfo")
    public ResponseMsg getOneUserInfo(@RequestBody JSONObject data) {
        try {
            List<UserTable> userTable = userTableService.getOneUserInfo(data);
            if (null != userTable) {
                return new ResponseMsg(Code.SUCCESS, userTable, "获取用户信息成功!");
            }
            return new ResponseMsg(Code.UNKNOW, null, "没有找到相关信息!");
        } catch (Exception e) {
            logger.info("获取用户信息失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "获取用户信息失败！" + e.getMessage());
        }
    }


    /**
     * 插入用户信息列表
     *
     * @return
     */
    @PostMapping("/insertUserInfo")
    public ResponseMsg insertUserInfo(@RequestBody UserTable user) {
        try {
            boolean save = userTableService.insertUserInfo(user);
            return new ResponseMsg(save ? Code.SUCCESS : Code.UNKNOW, save, save ? "插入用户信息成功" : "插入用户信息失败!");
        } catch (Exception e) {
            logger.info("插入用户信息失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "插入用户信息失败！" + e.getMessage());
        }
    }

    /**
     * 修改用户信息
     *
     * @return
     */
    @PostMapping("/updateUserInfo")
    public ResponseMsg updateUserInfo(@RequestBody UserTable user) {
        try {
            if(null==user.getId()){
                return new ResponseMsg(Code.UNKNOW, null, "id不能为空！" );
            }
            boolean save = userTableService.updateUserInfo(user);
            return new ResponseMsg(save ? Code.SUCCESS : Code.UNKNOW, save, save ? "修改用户信息成功" : "修改用户信息失败!");
        } catch (Exception e) {
            logger.info("修改用户信息失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "修改用户信息失败！" + e.getMessage());
        }
    }


    /**
     * 删除用户信息
     *
     * @return
     */
    @PostMapping("/deleteUserInfo")
    public ResponseMsg deleteUserInfo(@RequestBody UserTable user) {
        try {
            if(null==user.getId()){
                return new ResponseMsg(Code.UNKNOW, null, "id不能为空！" );
            }
            boolean save = userTableService.deleteUserInfo(user.getId());
            return new ResponseMsg(save ? Code.SUCCESS : Code.UNKNOW, save, save ? "删除用户信息成功" : "删除用户信息失败!");
        } catch (Exception e) {
            logger.info("删除用户信息失败！============》" + e.getMessage());
            return new ResponseMsg(Code.FAIL, null, "删除用户信息失败！" + e.getMessage());
        }
    }
}

