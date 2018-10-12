/**
 * 
 */
package metier;



/**
 * Classe Servicessup 
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class ServicesSup {

	protected int id_servicessup;
	protected String libelle_servicessup; 
	protected double prix_servicessup;
	
	
	
	/**
	 *  Constructeur sans paramètre
	 */
	public ServicesSup() {
		super();
	}



	/**
	 * @param id_servicessup
	 * @param libelle_servicessup
	 * @param prix_servicessup
	 */
	public ServicesSup(int id_servicessup, String libelle_servicessup, double prix_servicessup) {
		super();
		this.id_servicessup = id_servicessup;
		this.libelle_servicessup = libelle_servicessup;
		this.prix_servicessup = prix_servicessup;
	}



	/**
	 * @return the id_servicessup
	 */
	public int getId_servicessup() {
		return id_servicessup;
	}



	/**
	 * @param id_servicessup the id_servicessup to set
	 */
	public void setId_servicessup(int id_servicessup) {
		this.id_servicessup = id_servicessup;
	}



	/**
	 * @return the libelle_servicessup
	 */
	public String getLibelle_servicessup() {
		return libelle_servicessup;
	}



	/**
	 * @param libelle_servicessup the libelle_servicessup to set
	 */
	public void setLibelle_servicessup(String libelle_servicessup) {
		this.libelle_servicessup = libelle_servicessup;
	}



	/**
	 * @return the prix_servicessup
	 */
	public double getPrix_servicessup() {
		return prix_servicessup;
	}



	/**
	 * @param prix_servicessup the prix_servicessup to set
	 */
	public void setPrix_servicessup(double prix_servicessup) {
		this.prix_servicessup = prix_servicessup;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Servicessup [id_servicessup=" + id_servicessup + ", libelle_servicessup=" + libelle_servicessup
				+ ", prix_servicessup=" + prix_servicessup + "]";
	}
		
}
