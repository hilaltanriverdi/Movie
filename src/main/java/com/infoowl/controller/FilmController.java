package com.infoowl.controller;

import com.infoowl.model.Film;
import com.infoowl.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hilal on 3/10/2016.
 */

@Controller
public class FilmController {

    @Autowired
   private FilmRepository filmRepository;

    /**
     *save a film.
     *@return process message
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        Film film=new Film();
        film.setFilmName("the it crowd");
        film.setFilmType("comedi");
        filmRepository.save(film);
        System.out.println("eklendi");
        return "successfully added";
    }


    /**
     * delete the film
     * @return process message
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        Film film=new Film(1);
        filmRepository.delete(film);
        return "successfully deleted";
    }

    /**
     * update the film
     * @return process message
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(){
        long id=3;
        Film film=filmRepository.findOne(id);
        film.setFilmName("new Name");
        film.setFilmType("new Type");
        filmRepository.save(film);
        return "successfully updated";
    }

    /**
     * list all films
     * @return film field
     */
    @RequestMapping("/list")
    @ResponseBody
    public String list(){
        Iterable<Film> filmList=filmRepository.findAll();
        StringBuilder builder=new StringBuilder();
        for (Film film : filmList) {
            builder.append(film.getFilmId()+" ")
                    .append(film.getFilmName()+" ")
                    .append(film.getFilmType()+"/n");

        }
        return builder.toString();

    }





}
