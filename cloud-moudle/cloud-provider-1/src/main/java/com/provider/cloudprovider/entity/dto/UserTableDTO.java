package com.provider.cloudprovider.entity.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: carter
 * @Date: 2019/11/6 17:55
 * @Version 1.0
 */
@Data
public class UserTableDTO {

    private List<@Valid Save> save;

    @Data
    public static class Save{
        /**
         * id主键
         */
        private Integer id;

        /**
         * 用户名
         */
        @NotEmpty(message = "用户名不能为空")
        private String userName;

        /**
         * 密码
         */
        @NotEmpty(message = "密码不能为空")
        private String passWord;

        /**
         * 电话
         */
        private String phone;

        /**
         * 用户真实姓名
         */
        @NotEmpty(message = "用户真实姓名不能为空")
        private String realName;

        /**
         * 身份证号码
         */
        @NotEmpty(message = "身份证号码不能为空")
        private String identityCard;

        /**
         * 地址
         */
        private String address;

        /**
         * 年纪
         */
        @NotNull(message = "年纪不能为空")
        private Integer age;

        /**
         * 性别1男2女
         */
        @NotNull(message = "性别不能为空")
        private Integer sex;
    }

}
