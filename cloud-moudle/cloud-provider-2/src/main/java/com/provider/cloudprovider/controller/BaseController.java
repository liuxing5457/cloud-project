package com.provider.cloudprovider.controller;


import com.example.cloudcommons.resp.Code;
import com.example.cloudcommons.resp.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author Carter
 * @date 2019/12/10
 */
public class BaseController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 参数合法性检验
     *
     * @param result
     * @param responseMsg
     */
    protected void checkParamsIsValid(BindingResult result, ResponseMsg responseMsg) {
        StringBuilder errorMsg = new StringBuilder();
        if (result.hasErrors()) {
            responseMsg.setCode(Code.FAIL);
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                errorMsg.append(error.getDefaultMessage());
                // 异常使用; 分隔
                errorMsg.append(";");
            }
            responseMsg.setMsg(errorMsg.toString());
        }


    }


    /**
     * 返回所有不合法参数分号分隔
     *
     * @param result
     */
    protected String getErrorMsg(List<ObjectError> result) {
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError error : result) {
            errorMsg.append(error.getDefaultMessage());
            // 异常使用; 分隔
            errorMsg.append(";");
        }
        return errorMsg.toString();
    }

}
