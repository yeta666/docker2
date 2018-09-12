package com.docker2.pojo;

import javax.persistence.*;

public class User {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 登陆次数
     */
    @Column(name = "loginTime")
    private Integer logintime;

    public User(String id, String ip, Integer logintime) {
        this.id = id;
        this.ip = ip;
        this.logintime = logintime;
    }

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取ip地址
     *
     * @return ip - ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip地址
     *
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取登陆次数
     *
     * @return loginTime - 登陆次数
     */
    public Integer getLogintime() {
        return logintime;
    }

    /**
     * 设置登陆次数
     *
     * @param logintime 登陆次数
     */
    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", logintime=" + logintime +
                '}';
    }
}