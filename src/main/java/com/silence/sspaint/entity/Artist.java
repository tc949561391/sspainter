package com.silence.sspaint.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by tristan on 15/12/27.
 */
@Entity
public class Artist {

    @Id
    @GenericGenerator(name="uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32,nullable = false)
    private String uuid;                  //主键id



    @Column(name = "nick_name", length = 30 )
    private String nickName;         //昵称

    @Column(length = 5)
    private String Gender;             //性别

    @Column(length = 50, unique = true,nullable = false)
    private String loginId;             //登陆的id


    @Column(length = 50,nullable = false)
    private String password;               //密码



    private String icon;                    //头像的二进制


    @OneToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY, mappedBy = "author")
    private Set<PictureAlbum> pictureAlbums;         //该艺术家所有的相册




    @OneToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY, mappedBy = "holder")
    private Set<RelationShip> ConcernedMan;             //他关注的人





    @ManyToMany
    @JoinTable(name = "henchman_mapper",
            joinColumns = {
                    @JoinColumn(name = "holder_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "relater_id")
            }
    )
    private List<Artist> henchman;               //关注他的人



    @ManyToMany
    @JoinTable(name = "topic_mapper",
            joinColumns = {
                    @JoinColumn(name = "artist_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "topic_id")
            }
    )
    private List<Topic>  topics;                  //关注的话题社

    private String topicColor;                       //主题色
    @OneToOne(fetch = FetchType.LAZY)
    private DecorateZone decorateZone;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Set<PictureAlbum> getPictureAlbums() {
        return pictureAlbums;
    }

    public void setPictureAlbums(Set<PictureAlbum> pictureAlbums) {
        this.pictureAlbums = pictureAlbums;
    }

    public Set<RelationShip> getConcernedMan() {
        return ConcernedMan;
    }

    public void setConcernedMan(Set<RelationShip> concernedMan) {
        ConcernedMan = concernedMan;
    }

    public List<Artist> getHenchman() {
        return henchman;
    }

    public void setHenchman(List<Artist> henchman) {
        this.henchman = henchman;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getTopicColor() {
        return topicColor;
    }

    public void setTopicColor(String topicColor) {
        this.topicColor = topicColor;
    }

    public DecorateZone getDecorateZone() {
        return decorateZone;
    }

    public void setDecorateZone(DecorateZone decorateZone) {
        this.decorateZone = decorateZone;
    }

}