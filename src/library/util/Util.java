package library.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import library.model.Movie;

public class Util {
	
	public static ArrayList<Movie> parseResultSetToMovieList(ResultSet result) throws SQLException {
		if(result == null) {
			return null;
		}
		ResultSetMetaData resultMetaData = result.getMetaData();
		ArrayList<Movie> movieList = new ArrayList<>();
		
		Movie currentMovie;
		
		while(result.next()) {
			currentMovie = new Movie();
			for(int i = 1; i <= resultMetaData.getColumnCount(); i++) {
				currentMovie.addAttribute(resultMetaData.getColumnName(i), result.getString(i));
			}
			movieList.add(currentMovie);
		}
		
		
		
		return movieList;
	}

}
