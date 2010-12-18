/**
 * 
 */
package fr.softeam.movie.impl;

import java.util.Arrays;
import java.util.List;

import fr.softeam.movie.MovieSolver;
import fr.softeam.movie.enums.Movie;

/**
 * @author Olivier
 * 
 */
public class MovieSolverImpl implements MovieSolver {

	/**
	 * {@inheritDoc}
	 */
	public Movie request(String title) {

		List<Movie> listEnumMovies = Arrays.asList(Movie.values());
		for (Movie movie : listEnumMovies) {
			if (checkOrthographeDifferent(movie.getTitre(), title)) {
				return movie;
			}else if (checkOrthographeSubstring(movie.getTitre(), title)){
				return movie;
			}
		}

		return Movie.INCONNU;
	}

	private boolean checkOrthographeSubstring(String titreMovie, String request) {
		if (request==null) {
			return false;
		}
		
		boolean isSub = titreMovie.indexOf(request)>0;
		boolean superString = request.indexOf(titreMovie)>0;
		return (isSub || superString );

		
		
	}

	private boolean checkOrthographeDifferent(String titreMovie, String title) {
		if ("snotch".equals(title) && Movie.SNATCH.getTitre().equals(titreMovie)) {
			return true;
		}
		return titreMovie.equalsIgnoreCase(title);			
	}

}
