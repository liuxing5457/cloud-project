package com.provider.cloudprovider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.provider.cloudprovider.entity.UserTable;
import com.provider.cloudprovider.mapper.UserTableMapper;
import com.provider.cloudprovider.service.IUserTableService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Carter
 * @since 2019-11-06
 */
@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTable> implements IUserTableService {

    @Autowired
    private UserTableMapper userTableMapper;


    @Override
    public List<UserTable> getOneUserInfo(JSONObject data) {
        QueryWrapper<UserTable> queryWrapper = new QueryWrapper<>();
        if(null!=data.getInteger("id")){
            queryWrapper.eq("id",data.getInteger("id"));
        }
        if(StringUtils.isNotBlank(data.getString("userName"))){
            queryWrapper.eq("user_name",data.getString("userName"));
        }
        return userTableMapper.selectList(queryWrapper);
    }
}
