package com.zee.zee5app.service;

import java.io.FileNotFoundException;

import com.zee.zee5app.dto.Movie;

public interface MovieService {
	public Movie insertMovie(Movie movie) throws FileNotFoundException;
    public Movie updateMovie(String movieId, Movie movie);

    public Movie getMovieByMovieId(String movieId);
    public Movie[] getAllMovies();
    public Movie[] getAllMoviesByGenre(String genre);
    public Movie[] getAllMoviesByName(String movieName);
    public String deleteMovieByMovieId(String movieId);
}
