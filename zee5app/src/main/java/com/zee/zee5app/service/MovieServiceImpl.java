package com.zee.zee5app.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repo.MovieRepository;
import com.zee.zee5app.repo.MovieRepositoryImpl;

import lombok.Data;

public class MovieServiceImpl implements MovieService {
	
	 private MovieService service = MovieServiceImpl.getInstance();

	    private static MovieService movieService;

	    public static MovieService getInstance() {
	        if (movieService == null) {
	            movieService = new MovieServiceImpl();
	        }

	        return movieService;
	    }
	    
	
	    

	@Override
	public Movie insertMovie(Movie movie) throws FileNotFoundException {
		File file = new File(movie.getTrailer1());
		System.out.println(file.getName());
		
		if(movie.getTrailer1()==null || movie.getTrailer1()=="" || !file.exists()) {
			throw new FileNotFoundException("file not found");
		}
		else {
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
			System.out.println("file exists");
		}
		return movie;
	}

	@Override
	public Movie updateMovie(String movieId, Movie movie) {
		
		return null;
	}

	@Override
	public Movie getMovieByMovieId(String movieId) {
		
		return null;
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMoviesByGenre(String genre) {
		
		return null;
	}

	@Override
	public Movie[] getAllMoviesByName(String movieName) {
		
		return null;
	}

	@Override
	public String deleteMovieByMovieId(String movieId) {
		
		return null;
	}

}
