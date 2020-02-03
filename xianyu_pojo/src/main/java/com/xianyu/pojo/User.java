package com.xianyu.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class User {
    @Id
    private String sno;
    private String password;
    private String username;
    private String phonenumber;
    private String realname;
    private String adress;
    private String marjoy;
    private Float balance;

    public User(){};

    public User(String sno, String username) {
        this.sno = sno;
        this.username = username;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public User(String sno, String password, String username, String phonenumber, String realname, String adress, String marjoy, Float balance) {
        this.sno = sno;
        this.password = password;
        this.username = username;
        this.phonenumber = phonenumber;
        this.realname = realname;
        this.adress = adress;
        this.marjoy = marjoy;
        this.balance = balance;
    }
}
