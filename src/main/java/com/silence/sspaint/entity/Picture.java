package com.silence.sspaint.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by tristan on 15/12/29.
 */
@Entity
public class Picture {
    @Id
    @GenericGenerator(name="uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String uuid;                  //主键id

    private String title;

    private String path;

    private String descs;

    @ManyToOne(fetch = FetchType.EAGER)
    private PictureAlbum  album;




    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "picture_style_mapper",
            joinColumns = {
                    @JoinColumn(name = "style_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "picture_id")
            }

    )
    private List<Style> styles;



    public Date createDate;    //上传时间


    @OneToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            mappedBy = "picture",
            fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private List<PictureComment> comments;



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public PictureAlbum getAlbum() {
        return album;
    }

    public void setAlbum(PictureAlbum album) {
        this.album = album;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public List<PictureComment> getComments() {
        return comments;
    }

    public void setComments(List<PictureComment> comments) {
        this.comments = comments;
    }
}
