package com.infoowl.controller;

import com.infoowl.model.Film;
import com.infoowl.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hilal on 3/10/2016.
 */

@Controller
public class FilmController {

    @Autowired
   private FilmRepository filmRepository;


  /*  @RequestMapping("/")
    @ResponseBody
    public String create() {
        Film film=new Film();
        film.setFilmName("the it crowd");
        filmRepository.save(film);
        System.out.println("eklendi");
        return "its added";
    }
    */

    @RequestMapping("/create")
    @ResponseBody
    public String create(String filmAdı, String filmName) {
        Film film = null;
        try {
            film = new Film(filmAdı, filmName);
            filmRepository.save(film);
        }
        catch (Exception ex) {
           return "Error creating the film: " + ex.toString();
        }
        return "Film succesfully created! (id = " + film.getFilmId() + ")";
    }


    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Film film = new Film(id);
            filmRepository.delete(film);
        }
        catch (Exception ex) {
            return "Error deleting the film:" + ex.toString();
        }
        return "Film succesfully deleted!";
   }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id,String filmName, String filmType) {
        try {
            Film film = filmRepository.findOne(id);
            film.setFilmName(filmName);
            film.setFilmType(filmType);
            filmRepository.save(film);
        }
        catch (Exception ex) {
            return "Error updating the film: " + ex.toString();
        }
       return "Film succesfully updated!";
    }

}
