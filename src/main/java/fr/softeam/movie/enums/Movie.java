/**
 * 
 */
package fr.softeam.movie.enums;

/**
 * @author Olivier
 * 
 */
public enum Movie {
	INCONNU(""), PULP_FICTION("Pulp Fiction"), SNATCH("Snatch"), ODYSSEE(
			"2001 Odyssee de l'espace");
	private String titre;

	private Movie(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
