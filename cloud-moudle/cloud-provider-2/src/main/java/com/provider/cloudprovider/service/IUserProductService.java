package com.provider.cloudprovider.service;

import com.alibaba.fastjson.JSONObject;
import com.provider.cloudprovider.entity.UserProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户商品表 服务类
 * </p>
 *
 * @author Carter
 * @since 2019-11-06
 */
public interface IUserProductService extends IService<UserProduct> {

    List<UserProduct> getOneUserInfo(JSONObject data);

    Integer deductionInventory(Integer productId, Integer userId, Integer num);
}
