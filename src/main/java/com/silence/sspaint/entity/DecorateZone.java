package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 用户的特色装扮空间,比如空间的背景图
 * Created by tristan on 16/1/19.
 */
@Entity
public class DecorateZone {
    @Id
    @GenericGenerator(name="uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String uuid;                  //主键id


    private String bgPath;

    @ManyToMany
    @JoinTable(name = "tools_mapper",
            joinColumns = {
                    @JoinColumn(name = "artist_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "toole_id")
            }
    )
    private List<Tools> prefenceTools;


    private String tags;                          //标签

    private String selfJudge;                          //自我评价


    private String phone;                           //手机号

    private String school;                         //学校
    @OneToOne
    private SecurityInfo securityInfo;               //安全信息


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBgPath() {
        return bgPath;
    }

    public void setBgPath(String bgPath) {
        this.bgPath = bgPath;
    }

    public List<Tools> getPrefenceTools() {
        return prefenceTools;
    }

    public void setPrefenceTools(List<Tools> prefenceTools) {
        this.prefenceTools = prefenceTools;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSelfJudge() {
        return selfJudge;
    }

    public void setSelfJudge(String selfJudge) {
        this.selfJudge = selfJudge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public SecurityInfo getSecurityInfo() {
        return securityInfo;
    }

    public void setSecurityInfo(SecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
    }
}
