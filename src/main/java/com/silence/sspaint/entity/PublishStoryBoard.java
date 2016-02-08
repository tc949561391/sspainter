package com.silence.sspaint.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 杰 on 2016/2/8.
 */
@Entity
public class PublishStoryBoard {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32, nullable = false)
    private String uuid;


    @OneToMany
    private List<Picture> pictures;


    private Date publishDate;




}
