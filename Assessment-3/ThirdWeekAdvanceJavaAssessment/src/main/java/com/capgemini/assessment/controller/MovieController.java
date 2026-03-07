/**
 * 
 */
package com.capgemini.assessment.controller;

/**
 * 
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.capgemini.assessment.model.Movie;
import com.capgemini.assessment.service.MovieService;




@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService service;

   
    @GetMapping("/")
    public String viewMovies(Model model) {

        model.addAttribute("movies", service.getAllMovies());

        return "index";
    }


    
    @GetMapping("/add")
    public String addMovieForm(Model model) {

        model.addAttribute("movie", new Movie());

        return "addMovie";
    }


    
    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie) {

        service.saveMovie(movie);

        return "redirect:/movies/";
    }


    
    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable int id, Model model) {

        model.addAttribute("movie",
                service.getMovieById(id));

        return "editMovie";
    }


    
    @PostMapping("/update")
    public String updateMovie(@ModelAttribute Movie movie) {

        service.saveMovie(movie);

        return "redirect:/movies/";
    }



    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id) {

        service.deleteMovie(id);

        return "redirect:/movies/";
    }

}
