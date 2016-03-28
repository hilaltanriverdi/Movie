package com.infoowl.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hilal on 3/21/2016.
 */

@Entity
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date likeDate;

    @Enumerated(EnumType.STRING)
    private LikeType likeType;


    @ManyToOne
    private Film film;

    @ManyToOne
    private UserAcco userAcco;


    public UserLike() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public UserAcco getUserAcco() {
        return userAcco;
    }

    public void setUserAcco(UserAcco userAcco) {
        this.userAcco = userAcco;
    }


    public LikeType getLikeType() {
        return likeType;
    }

    public UserLike setLikeType(LikeType likeType) {
        this.likeType = likeType;
        return this;
    }
}
