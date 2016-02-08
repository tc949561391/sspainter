package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by tristan on 15/12/29.
 */


@Entity
public class PictureAlbum {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32,nullable = false)
    private String uuid;                  //主键id

    @OneToOne
    private Picture backGround;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    @ManyToOne(fetch = FetchType.EAGER)
    private Artist author;

    @OneToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY, mappedBy = "album")
    private Set<Picture> pictures;


    private boolean isPublic;       //是不是公共可访问的


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Artist getAuthor() {
        return author;
    }

    public void setAuthor(Artist author) {
        this.author = author;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }


    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public Picture getBackGround() {
        return backGround;
    }

    public void setBackGround(Picture backGround) {
        this.backGround = backGround;}
}
