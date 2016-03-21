package com.infoowl.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by hilal on 3/21/2016.
 */

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likeId;
    private Date likeDate;
    private String likeType;

    @ManyToOne @JoinColumn(name = "filmId")
    private Film film;

    @ManyToOne @JoinColumn(name = "userId")
    private User user;


    public Like() {
    }

    public Like(Date likeDate, String likeType) {
        this.likeDate = likeDate;
        this.likeType = likeType;
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }

    public String getLikeType() {
        return likeType;
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType;
    }
}
