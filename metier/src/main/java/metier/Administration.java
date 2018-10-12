/**
 * 
 */
package metier;
import java.time.LocalDate;

/**
 * Classe Administration 
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class Administration extends Personne{

	protected int idAdministration;
	protected int idProfession;
	protected int idDiplome;
	protected LocalDate dateRecrutementAdministration;
	/**
	 * Constructeur sans paramètre 
	 */
	public Administration() {
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
	 * @param idAdministration
	 * @param idProfession
	 * @param idDiplome
	 * @param dateRecrutementAdministration
	 */
	public Administration(char sexe, String prenom, String nom, LocalDate dateNaissance, String lieuNaissance,
			String adresse, int telephone, String email, int idAdministration, int idProfession, int idDiplome,
			LocalDate dateRecrutementAdministration) {
		super(sexe, prenom, nom, dateNaissance, lieuNaissance, adresse, telephone, email);
		this.idAdministration = idAdministration;
		this.idProfession = idProfession;
		this.idDiplome = idDiplome;
		this.dateRecrutementAdministration = dateRecrutementAdministration;
	}
	/**
	 * @return the idAdministration
	 */
	public int getIdAdministration() {
		return idAdministration;
	}
	/**
	 * @param idAdministration the idAdministration to set
	 */
	public void setIdAdministration(int idAdministration) {
		this.idAdministration = idAdministration;
	}
	/**
	 * @return the idProfession
	 */
	public int getIdProfession() {
		return idProfession;
	}
	/**
	 * @param idProfession the idProfession to set
	 */
	public void setIdProfession(int idProfession) {
		this.idProfession = idProfession;
	}
	/**
	 * @return the idDiplome
	 */
	public int getIdDiplome() {
		return idDiplome;
	}
	/**
	 * @param idDiplome the idDiplome to set
	 */
	public void setIdDiplome(int idDiplome) {
		this.idDiplome = idDiplome;
	}
	/**
	 * @return the dateRecrutementAdministration
	 */
	public LocalDate getDateRecrutementAdministration() {
		return dateRecrutementAdministration;
	}
	/**
	 * @param dateRecrutementAdministration the dateRecrutementAdministration to set
	 */
	public void setDateRecrutementAdministration(LocalDate dateRecrutementAdministration) {
		this.dateRecrutementAdministration = dateRecrutementAdministration;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Administration [idAdministration=" + idAdministration + ", idProfession=" + idProfession
				+ ", idDiplome=" + idDiplome + ", dateRecrutementAdministration=" + dateRecrutementAdministration
				+ ", sexe=" + sexe + ", prenom=" + prenom + ", nom=" + nom + ", dateNaissance=" + dateNaissance
				+ ", lieuNaissance=" + lieuNaissance + ", adresse=" + adresse + ", telephone=" + telephone + ", email="
				+ email + "]";
	}
	
	
}
