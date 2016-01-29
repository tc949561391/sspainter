package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
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

    @Transient
    private File file;


    @ManyToMany
    @JoinTable(name = "picture_style_mapper",
            joinColumns = {
                    @JoinColumn(name = "style_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "picture_id")
            }
    )

    private Set<Style> styles;

    @OneToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY, mappedBy = "picture")
    private Set<PictureComment> comments;


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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Set<Style> getStyles() {
        return styles;
    }

    public void setStyles(Set<Style> styles) {
        this.styles = styles;
    }

    public Set<PictureComment> getComments() {
        return comments;
    }

    public void setComments(Set<PictureComment> comments) {
        this.comments = comments;
    }
}
