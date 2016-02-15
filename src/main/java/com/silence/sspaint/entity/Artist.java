package com.silence.sspaint.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by tristan on 15/12/27.
 */
@Entity
public class Artist implements UserDetails{

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32, nullable = false)
    private String uuid;                  //主键id


    @Column(name = "nick_name", length = 30)
    private String nickName;         //昵称

    @Column(length = 5)
    private String Gender;             //性别

    @Column(length = 50, unique = true, nullable = false)
    private String userName;             //登陆的id


    @Column(length = 50, nullable = false)
    private String password;               //密码


    private String icon;                    //头像的路径


    private String topicColor;                       //主题色


    private String role;                         //角色


    @OneToOne(fetch = FetchType.LAZY)
    private DecorateZone decorateZone;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getTopicColor() {
        return topicColor;
    }

    public void setTopicColor(String topicColor) {
        this.topicColor = topicColor;
    }

    public DecorateZone getDecorateZone() {
        return decorateZone;
    }

    public void setDecorateZone(DecorateZone decorateZone) {
        this.decorateZone = decorateZone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    /**
     * spring security权限
     * @return
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {


        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return null;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }


    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }


}
