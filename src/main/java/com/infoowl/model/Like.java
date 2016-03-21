package com.infoowl.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hilal on 3/21/2016.
 */

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long likeId;
    private long likeNumber;
    private long dislikeNumber;

    @ManyToOne @JoinColumn(name = "filmId")
    private Film film;

    @ManyToOne @JoinColumn(name = "userId")
    private User user;


    public Like() {
    }

    public Like(long likeId, long likeNumber, long dislikeNumber) {
        this.likeId = likeId;
        this.likeNumber = likeNumber;
        this.dislikeNumber = dislikeNumber;
    }

    public long getLikeId() {
        return likeId;
    }

    public void setLikeId(long likeId) {
        this.likeId = likeId;
    }

    public long getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(long likeNumber) {
        this.likeNumber = likeNumber;
    }

    public long getDislikeNumber() {
        return dislikeNumber;
    }

    public void setDislikeNumber(long dislikeNumber) {
        this.dislikeNumber = dislikeNumber;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
