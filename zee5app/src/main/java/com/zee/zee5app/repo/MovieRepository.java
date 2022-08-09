package com.zee.zee5app.repo;

import java.util.Optional;

import com.zee.zee5app.dto.Movie;

public interface MovieRepository {
    
    public Movie insertMovie(Movie movie);
    public Movie updateMovie(String movieId, Movie movie);

    public Optional<Movie> getMovieByMovieId(String movieId);
    public Movie[] getAllMovies();
    public Movie[] getAllMoviesByGenre(String genre);
    public Movie[] getAllMoviesByName(String movieName);
    public String deleteMovieByMovieId(String movieId);
}
