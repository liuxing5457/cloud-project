package com.provider.cloudprovider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.provider.cloudprovider.entity.UserProduct;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.provider.cloudprovider.mapper.UserProductMapper;
import com.provider.cloudprovider.service.IUserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户商品表 服务实现类
 * </p>
 *
 * @author Carter
 * @since 2019-11-06
 */
@Service
public class UserProductServiceImpl extends ServiceImpl<UserProductMapper, UserProduct> implements IUserProductService {

    @Autowired
    private UserProductMapper userProductMapper;

    @Override
    public List<UserProduct> getOneUserInfo(JSONObject data) {
        QueryWrapper<UserProduct> queryWrapper = new QueryWrapper<>();
        if(null!=data.getInteger("id")){
            queryWrapper.eq("id",data.getInteger("id"));
        }
        if(null!=data.getInteger("userId")){
            queryWrapper.eq("user_id",data.getInteger("userId"));
        }
        return userProductMapper.selectList(queryWrapper);
    }

    /**
     * 扣减库存
     * @param productId
     * @param userId
     * @param num
     * @return
     */
    @Override
    public Integer deductionInventory(Integer productId, Integer userId, Integer num) {
        return userProductMapper.deductionInventory(productId, userId, num);
    }

}
