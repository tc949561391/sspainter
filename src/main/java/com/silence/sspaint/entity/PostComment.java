package com.silence.sspaint.entity;

import javafx.geometry.Pos;
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
public class PostComment extends Comment{

    @ManyToOne
    private Post post;


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
