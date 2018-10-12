/**
 * 
 */
package metier;

import java.time.LocalDate;

/**
 * Class Tuteur
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class Tuteur extends Personne {

	protected int idTuteur;
	
	

	/**
	 * Constructeur sans paramètre
	 */
	public Tuteur() {
		super();
	}



	/**
	 * @param sexe
	 * @param prenom
	 * @param nom
	 * @param dateNaissance
	 * @param lieuNaissance
	 * @param adresse
	 * @param telephone
	 * @param email
	 */
	public Tuteur(char sexe, String prenom, String nom, LocalDate dateNaissance, String lieuNaissance, String adresse,
			int telephone, String email) {
		super(sexe, prenom, nom, dateNaissance, lieuNaissance, adresse, telephone, email);
	}



	/**
	 * @return the idTuteur
	 */
	public int getIdTuteur() {
		return idTuteur;
	}



	/**
	 * @param idTuteur the idTuteur to set
	 */
	public void setIdTuteur(int idTuteur) {
		this.idTuteur = idTuteur;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tuteur [idTuteur=" + idTuteur + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", email=" + email + "]";
	}
		
}
