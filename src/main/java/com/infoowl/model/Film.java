package com.infoowl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by hilal on 3/10/2016.
 */
@Entity
public class Film {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long filmId;
    private String filmName;
    private String filmType;

    public Film() {

    }

    public Film(long filmId) {
        this.filmId=filmId;
    }



    public Film(String filmName, String filmType) {
        this.filmName = filmName;
        this.filmType = filmType;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }
}
