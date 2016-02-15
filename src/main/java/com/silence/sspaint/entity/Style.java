package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by tristan on 15/12/29.
 */
@Entity
public class Style {
    @Id
    @GenericGenerator(name="uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String uuid;                  //主键id


    private String styleName;


    //父类型
    @ManyToOne(fetch = FetchType.LAZY)
    private Style parentStyle;



    //所有子类型
    @OneToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY, mappedBy = "parentStyle")
    private Set<Style> subStyle;

    private boolean isRoot=false;            //是不是根级别的style,如果是根级别的style,则用户不可以更改其类型


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public Style getParentStyle() {
        return parentStyle;
    }

    public void setParentStyle(Style parentStyle) {
        this.parentStyle = parentStyle;
    }

    public Set<Style> getSubStyle() {
        return subStyle;
    }

    public void setSubStyle(Set<Style> subStyle) {
        this.subStyle = subStyle;
    }



    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }
}
