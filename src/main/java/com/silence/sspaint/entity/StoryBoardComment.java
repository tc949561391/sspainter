package com.silence.sspaint.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by 杰 on 2016/2/8.
 */
@Entity
public class StoryBoardComment extends  Comment{

    @ManyToOne
    private PublishStoryBoard storyBoard;

    public PublishStoryBoard getStoryBoard() {
        return storyBoard;
    }

    public void setStoryBoard(PublishStoryBoard storyBoard) {
        this.storyBoard = storyBoard;
    }
}
