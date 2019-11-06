package com.provider.cloudprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.provider.cloudprovider.entity.UserProduct;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户商品表 Mapper 接口
 * </p>
 *
 * @author Carter
 * @since 2019-11-06
 */
public interface UserProductMapper extends BaseMapper<UserProduct> {

    /**
     * 扣减库存
     * @param productId
     * @param userId
     * @param num
     * @return
     */
    Integer deductionInventory(@Param("id") Integer productId, @Param("userId") Integer userId,@Param("num") Integer num);
}
