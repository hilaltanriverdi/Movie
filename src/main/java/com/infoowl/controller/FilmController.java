package com.infoowl.controller;

import com.infoowl.model.Film;
import com.infoowl.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hilal on 3/10/2016.
 */

@CrossOrigin(value = "http://localhost:63342", maxAge = 3600)
@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;


    /**
     * save a film.
     *
     * @return process message
     */
    @RequestMapping(value = "/movies/create", method = RequestMethod.POST)
    @ResponseBody
    public Film create(@RequestBody Film film) {

        System.out.println("create");
        filmRepository.save(film);
        return film;
    }


    /**
     * delete the film
     *
     * @return process message
     */
    @RequestMapping(value = "/movies/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(long id) {
        Film film = new Film(id);
        filmRepository.delete(film);
        return "successfully deleted";
    }

    /**
     * update the film
     *
     * @return process message
     */
    @RequestMapping(value = "/movies/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(long id, String filmName, String filmType) {
        Film film = filmRepository.findOne(id);
        film.setFilmName(filmName);
        film.setFilmType(filmType);
        filmRepository.save(film);
        return "successfully updated";
    }

    /**
     * list all films
     *
     * @return film list
     */
    @RequestMapping(value = "/movies/list", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Film> list() {
        System.out.print("list");
        Iterable<Film> filmList = filmRepository.findAll();
        return filmList;

    }

}
