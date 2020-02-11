package com.xianyu.dto;

import com.xianyu.pojo.User;

public class UserInfo {
    private String sno;
    private String username;
    private String phonenumber;
    private String realname;
    private String adrress;
    private String marjoy;
    private Float balance;
    public UserInfo(User user){
        this.sno=user.getSno();
        this.username=user.getUsername();
        this.phonenumber=user.getPhonenumber();
        this.realname=user.getRealname();
        this.adrress=user.getAdress();
        this.balance=user.getBalance();
        this.marjoy=user.getMarjoy();
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }

    public String getMarjoy() {
        return marjoy;
    }

    public void setMarjoy(String marjoy) {
        this.marjoy = marjoy;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
