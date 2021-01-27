package com.huatech.mall.vo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author like
 * @date 2021-01-27 2:48 下午
 **/
public class LoginParam implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginParam{" +
                "username='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}