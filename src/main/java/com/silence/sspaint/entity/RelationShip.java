package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by tristan on 15/12/29.
 */
@Entity
public class RelationShip {
    @Id
    @GenericGenerator(name="uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String uuid;                  //主键id


    @ManyToOne(fetch = FetchType.EAGER)
    private Artist holder;


    @OneToOne
    private Artist related;


    private String remark;    //备注


    private String groupName; //分组



    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Artist getHolder() {
        return holder;
    }

    public void setHolder(Artist holder) {
        this.holder = holder;
    }

    public Artist getRelated() {
        return related;
    }

    public void setRelated(Artist related) {
        this.related = related;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
