/**
 * 
 */
package com.capgemini.assessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 */
@Entity
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String genre;
    private String director;
    private int releaseYear;
    private double rating;
	/**
	 * 
	 */
	public Movie() {
		super();
	}
	/**
	 * @param id
	 * @param title
	 * @param genre
	 * @param director
	 * @param releaseYear
	 * @param rating
	 */
	public Movie(int id, String title, String genre, String director, int releaseYear, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}
	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
    
    

}
