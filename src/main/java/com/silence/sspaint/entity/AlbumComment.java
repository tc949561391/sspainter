package com.silence.sspaint.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * 对于艺术家发表的画册或者每一个作品进行评价,保存评价的内容,
 * <p/>
 * <p/>
 * <p/>
 * Created by tristan on 16/1/19.
 */
@Entity
public class AlbumComment extends Comment{

    @ManyToOne(fetch=FetchType.LAZY)
    private PictureAlbum album;

    public PictureAlbum getAlbum() {
        return album;
    }

    public void setAlbum(PictureAlbum album) {
        this.album = album;
    }
}
