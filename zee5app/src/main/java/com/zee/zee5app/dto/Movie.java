package com.zee.zee5app.dto;

import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.IdNotFoundException;
import com.zee.zee5app.exceptions.InvalidLanguageException;
import com.zee.zee5app.exceptions.InvalidNameException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Movie {
	private String movieId;
	
    public void setMovieId(String movieId) throws IdNotFoundException {
    	int len = movieId.length();
    	if(len>=5 && len<=7) {
    		this.movieId = movieId;
    	}
    	else {
    		throw new IdNotFoundException("Invalid Movie Id");
    	}
	}
	public void setActors(String[] actors) {
		
		
		this.actors = actors;
	}
	public void setMovieName(String movieName) throws InvalidNameException {
		int len = movieName.length();
		if(len<3 || movieName==" " || movieName==null) {
			throw new InvalidNameException("Invalid Movie Name");
		} else {
		this.movieName = movieName;
		}
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setGenre(Genres genre) {
		this.genre = genre;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public void setLanguages(String[] languages) throws InvalidLanguageException {
		for(String string: languages) {
			try {
				if(Languages.valueOf(string)==null) {
					throw new InvalidLanguageException("Invlid Exception");
				}
					}
				
			 catch (IllegalArgumentException e) {
				
				throw new InvalidLanguageException("Invlid language providedException");
			}
			
		}
		this.languages = languages;
		System.out.println("Success");
		
	}
	public void setMovieLength(float movieLength){
		if (movieLength<1) {
			throw new ArithmeticException("Invalid lenght, cant be less than zero");
			
		}else {
		this.movieLength = movieLength;
		}
	}

    public Movie(String movieId, String[] actors, String movieName, String director, Genres genre, String production,
			String[] languages, float movieLength) throws IdNotFoundException, InvalidLanguageException {
		super();
		this.setMovieId(movieId);
		this.actors = actors;
		this.movieName = movieName;
		this.director = director;
		this.genre = genre;
		this.production = production;
		this.setLanguages(languages);
		this.setMovieLength(movieLength);
	}
    
    public Movie() {
		// TODO Auto-generated constructor stub
	}

	private String actors[];
    private String movieName;
    private String director;
    private Genres genre;
    private String production;
    private String languages[];
    private float movieLength;
    private String trailer1;
    //private byte[] trailer2;
    
}
