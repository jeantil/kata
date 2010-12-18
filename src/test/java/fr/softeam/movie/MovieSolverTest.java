/**
 * 
 */
package fr.softeam.movie;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import fr.softeam.movie.enums.Movie;
import fr.softeam.movie.impl.MovieSolverImpl;

/**
 * @author Olivier
 * 
 */
public class MovieSolverTest {

	/**
	 * Test method for
	 * {@link fr.softeam.movie.MovieSolver#request(java.lang.String)}.
	 */
	@Test
	public void testRequestChaineVide() {
		MovieSolver solver = new MovieSolverImpl();
		Movie request = solver.request("");
		assertEquals(Movie.INCONNU, request);
	}

	@Test
	public void testRequestNull() {
//		MovieSolver mock = mock(MovieSolver.class);
//		when(mock.request(null)).thenReturn(Movie.INCONNU);
		
		MovieSolver solver = new MovieSolverImpl();
		Movie request = solver.request(null);
		assertEquals(request, Movie.INCONNU);
		
	}
	
	@Test
	public void testRequestBonFilm() {
//		MovieSolver mock = mock(MovieSolver.class);
//		when(mock.request(null)).thenReturn(Movie.INCONNU);
		
		MovieSolver solver = new MovieSolverImpl();
		Movie request = solver.request("Pulp Fiction");
		assertEquals(request, Movie.PULP_FICTION);
		
	}	

	@Test
	public void testRequestBonFilmCasse() {
//		MovieSolver mock = mock(MovieSolver.class);
//		when(mock.request(null)).thenReturn(Movie.INCONNU);
		
		MovieSolver solver = new MovieSolverImpl();
		Movie request = solver.request("pulp fiction");
		assertEquals(request, Movie.PULP_FICTION);
		
	}	
	
	@Test
	public void testRequestFilmSnatch() {
		MovieSolver solver = new MovieSolverImpl();
		Movie request = solver.request("snatch");
		assertEquals(request, Movie.SNATCH);
	}	
	
	@Test
	public void testRequestFilmOrthographeDiff() {
		MovieSolver solver = new MovieSolverImpl();
		Movie request = solver.request("snotch");
		assertEquals(Movie.SNATCH, request);
	}
	
	@Test
	public void testRequestFilmSubstring() {
		MovieSolver solver = new MovieSolverImpl();
		Movie request = solver.request("tch");
		assertEquals(Movie.SNATCH, request);
	}
	
	@Test
	public void testRequestFilmSuperstring() {
		MovieSolver solver = new MovieSolverImpl();
		Movie request = solver.request("snatche");
		assertEquals(Movie.SNATCH, request);
	}

	//
//	@Test
//	public void testRequest3() {
//		String title = "Space Odysseus";
//
//		MovieSolver mock = mock(MovieSolver.class);
//		when(mock.request(title)).thenReturn(Movie.ODYSSEE);
//		Movie request = mock.request(title);
//
//		assertNotNull(request);
//		assertEquals(request, Movie.ODYSSEE);
//	}
}
