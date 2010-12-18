/**
 * 
 */
package fr.softeam.movie;

import fr.softeam.movie.enums.Movie;

/**
 * @author Olivier
 * 
 */
public interface MovieSolver {
	/**
	 * Determine the correct movie for vague and mostly wrong titles
	 * 
	 * @param title
	 *            the requested movie title
	 * @return the according correct movie (an enum)
	 */
	Movie request(String title);
}
