package com.zee.zee5app;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.IdNotFoundException;
import com.zee.zee5app.exceptions.InvalidLanguageException;


public class Main1 {
	public static void main(String[] args) {
		String[] actors = {"a", "b", "c"};
		String[] languages = {Languages.KANNADA.name(), Languages.TELUGU.name()};
		Genres genre = Genres.ACTION;
		try {
			Movie movie = new Movie("VR00007", actors, "Vikrant Rona", "director", genre, "prod", languages, 0);
			System.out.println(movie);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidLanguageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}