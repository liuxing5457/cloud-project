package com.provider.cloudprovider.entity.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: carter
 * @Date: 2019/11/6 17:55
 * @Version 1.0
 */
public class UserTableDTO {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
