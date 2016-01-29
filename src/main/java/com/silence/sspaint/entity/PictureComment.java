package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 对于艺术家发表的画册或者每一个作品进行评价,保存评价的内容,
 * <p/>
 * <p/>
 * <p/>
 * Created by tristan on 16/1/19.
 */
@Entity
public class PictureComment {

    @Id
    @GenericGenerator(name="uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String uuid;                  //主键id

    @OneToOne
    private Artist from;

    @OneToOne
    private Artist to;


    private String content;        //评论的内容


    @OneToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY, mappedBy = "superComment")
    private List<PictureComment> comments;


    @ManyToOne(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private PictureComment superComment;

    private boolean isRoot = true;


    @Temporal(TemporalType.DATE)
    private Date commentDate;       //评论的时间


    @ManyToOne(fetch=FetchType.LAZY)
    private Picture picture;


    @ManyToOne(fetch=FetchType.LAZY)
    private PictureAlbum album;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Artist getFrom() {
        return from;
    }

    public void setFrom(Artist from) {
        this.from = from;
    }

    public Artist getTo() {
        return to;
    }

    public void setTo(Artist to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PictureComment> getComments() {
        return comments;
    }

    public void setComments(List<PictureComment> comments) {
        this.comments = comments;
    }

    public PictureComment getSuperComment() {
        return superComment;
    }

    public void setSuperComment(PictureComment superComment) {
        this.superComment = superComment;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public PictureAlbum getAlbum() {
        return album;
    }

    public void setAlbum(PictureAlbum album) {
        this.album = album;
    }
}
