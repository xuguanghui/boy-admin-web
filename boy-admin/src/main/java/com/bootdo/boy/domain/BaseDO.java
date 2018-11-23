package com.bootdo.boy.domain;

/**
 * Created by xgh on 2018/11/23.
 */
public class BaseDO {
    //添加人名称
    private String userAddname;

    private  String modifyname;

    public String getUserAddname() {
        return userAddname;
    }

    public void setUserAddname(String userAddname) {
        this.userAddname = userAddname;
    }

    public String getModifyname() {
        return modifyname;
    }

    public void setModifyname(String modifyname) {
        this.modifyname = modifyname;
    }
}
