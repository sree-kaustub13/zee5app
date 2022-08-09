package com.zee.zee5app.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.utils.DBUtils;


public class MovieRepoImpl implements MovieRepository {
	private List<Movie> movies = new LinkedList<>();
	private MovieRepoImpl() {
        // TODO Auto-generated constructor stub
    }
    
    private static MovieRepository movieRepo;
    
    public static MovieRepository getInstance() {
        // userRepo object
        
        if(movieRepo == null) {
            movieRepo = new MovieRepoImpl();
            
        }
        
        return movieRepo;
    }
	
    private DBUtils dbUtils = DBUtils.getInstance();
    
	@Override
	public Movie insertMovie(Movie movie) {
		
		 Connection connection = null;        
	        PreparedStatement preparedStatement = null;
	        String insertStatement = "insert into movie_table" 
	                + "(movieid, actors, moviename, director, genre, production, langauges, movielength)"
	                + "values(?,?,?,?,?,?,?,?)";

	        connection = dbUtils.getConnection();
	        String actors = String.join(",", movie.getActors());
	        String languages = String.join(",", movie.getLanguages());
	        try {
	            preparedStatement = connection.prepareStatement(insertStatement);
	            preparedStatement.setString(1, movie.getMovieId());
	            preparedStatement.setString(2, actors);
	            preparedStatement.setString(3, movie.getMovieName());
	            preparedStatement.setString(4, movie.getDirector());
	            preparedStatement.setString(5, movie.getGenre().toString());
	            preparedStatement.setString(6, movie.getProduction());
	            preparedStatement.setString(7, languages);
	            preparedStatement.setFloat(8, movie.getMovieLength());
	            int result = preparedStatement.executeUpdate();

	            if(result > 0) {
	                return movie;
	            }
	            else {
	                return null;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        finally {
	            dbUtils.closeConnection(connection);
	        }
	        return null;
	}

	@Override
	public Movie updateMovie(String movieId, Movie movie) {
		
		return null;
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
//		for(Movie movie : movies) {
//			if(movie!=null && movieId.equals(movie.getMovieId())) {
//				return Optional.of(movie);
//				
//			}
//		}return Optional.empty();
		
		Connection connection = null;      
        PreparedStatement preparedStatement = null;
        String query = "select * from movie_table where movieid=?";
        ResultSet resultSet = null;
        connection = dbUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, movieId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Movie movie = new Movie();
                movie.setMovieId(resultSet.getString("movieid"));
                String[] arrOfStr = resultSet.getString("actors").split(",");
                movie.setActors(arrOfStr);
                movie.setMovieName(resultSet.getString("lastname"));
                movie.setDirector(resultSet.getString("email"));
                movie.setGenre(resultSet.getString("email"));
                movie.setProduction(resultSet.getString("email"));
                movie.setLanguages(resultSet.getString("email"));
                movie.setMovieLength(resultSet.getBoolean("movielength"));
                return Optional.of(movie);
            }
            else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            dbUtils.closeConnection(connection);
        }
        return Optional.empty();
		
	}
	

	@Override
	public Movie[] getAllMovies() {

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
