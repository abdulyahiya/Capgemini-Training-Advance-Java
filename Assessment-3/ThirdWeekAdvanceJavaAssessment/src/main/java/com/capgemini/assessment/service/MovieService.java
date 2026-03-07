/**
 * 
 */
package com.capgemini.assessment.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.assessment.model.Movie;
import com.capgemini.assessment.repository.MovieRepository;





/*
 * Service Interface
 */
public interface MovieService {

    // Add or Update Movie
    void saveMovie(Movie movie);

    // Get All Movies
    List<Movie> getAllMovies();

    // Get Movie By ID
    Movie getMovieById(int id);

    // Delete Movie
    void deleteMovie(int id);

}



/*
 * Service Implementation
 */
@Service
class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;


    // Save Movie (Create + Update)
    @Override
    public void saveMovie(Movie movie) {

        repository.save(movie);

    }


    
    @Override
    public List<Movie> getAllMovies() {

        return repository.findAll();

    }


    // Get Movie By ID
    @Override
    public Movie getMovieById(int id) {

        return repository.findById(id).get();

    }


   
    @Override
    public void deleteMovie(int id) {

        repository.deleteById(id);

    }

}
