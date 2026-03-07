/**
 * 
 */
package com.capgemini.assessment.repository;

/**
 * 
 */


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assessment.model.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
