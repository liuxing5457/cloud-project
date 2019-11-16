package com.oauth2.cloudoauth2.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName GenPwd
 * @Description TODO
 * @Author  xuzibang
 * @Date 2019/11/16
 */
public class GenPwd {

    public static void main(String[] args) {
        String pass = "xuzibang20191116";
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String hashPass = encode.encode(pass);
        System.out.println(hashPass);
    }

}
