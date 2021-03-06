package com.provider.cloudprovider.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.provider.cloudprovider.entity.UserTable;
import com.provider.cloudprovider.entity.dto.UserTableDTO;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Carter
 * @since 2019-11-06
 */
public interface IUserTableService extends IService<UserTable> {

    List<UserTable> getOneUserInfo(JSONObject data);

    boolean insertUserInfo(UserTableDTO user);

    boolean updateUserInfo(UserTable user);

    boolean deleteUserInfo(Integer id);
}
