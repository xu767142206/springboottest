package com.xyc.wms.validator;

import javax.validation.constraints.NotEmpty;

public class LoginUser {

    @NotEmpty
    private String userName;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @NotEmpty
    private String passWord;
}
