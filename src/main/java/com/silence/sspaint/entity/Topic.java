package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tristan on 16/1/19.
 */
@Entity
public class Topic {

    @Id
    @GenericGenerator(name="uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String uuid;                  //主键id


    private String topcIcon;


    private String topicIntroduct;


    private String type;

    @OneToOne
    private Style style;


    private String tupicName;

    @ManyToMany
    @JoinTable(name = "topic_mapper",
            joinColumns = {
                    @JoinColumn(name = "artist_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "topic_id")
            }
    )
    private List<Artist> members;

    @OneToOne
    private Artist creater;

    @ManyToMany
    @JoinTable(name = "topic_mapper",
            joinColumns = {
                    @JoinColumn(name = "topic_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "manager_id")
            }
    )
    private List<Artist> managers;

    @OneToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY, mappedBy = "topic")
    private List<Post> posts;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTopcIcon() {
        return topcIcon;
    }

    public void setTopcIcon(String topcIcon) {
        this.topcIcon = topcIcon;
    }

    public String getTopicIntroduct() {
        return topicIntroduct;
    }

    public void setTopicIntroduct(String topicIntroduct) {
        this.topicIntroduct = topicIntroduct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getTupicName() {
        return tupicName;
    }

    public void setTupicName(String tupicName) {
        this.tupicName = tupicName;
    }

    public List<Artist> getMembers() {
        return members;
    }

    public void setMembers(List<Artist> members) {
        this.members = members;
    }

    public Artist getCreater() {
        return creater;
    }

    public void setCreater(Artist creater) {
        this.creater = creater;
    }

    public List<Artist> getManagers() {
        return managers;
    }

    public void setManagers(List<Artist> managers) {
        this.managers = managers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
