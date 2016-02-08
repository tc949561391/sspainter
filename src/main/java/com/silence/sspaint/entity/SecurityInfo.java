package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 一个艺术家的安全信息
 * Created by tristan on 15/12/29.
 */
@Entity
public class SecurityInfo {

    @Id
    @GenericGenerator(name="uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String uuid;                  //主键id

    @OneToOne
    private Artist artist;


    private String trueName;            //真实姓名


    private String idCardNumber;           //身份证号码


    @Column(length = 11)
    private String phone;                 //手机号码


    private String address;                  //地址

    @Column(length = 30)
    private String lastIp;              //最后登陆的ip


    private String email;               //用户的emial邮箱



    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;          //最后登陆的时间





    @Temporal(TemporalType.DATE)
    private Date registerDate;          //注册的时间


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
