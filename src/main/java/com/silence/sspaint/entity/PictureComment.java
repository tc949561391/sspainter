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
public class PictureComment extends Comment{


    @ManyToOne(fetch=FetchType.LAZY)
    private Picture picture;

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
