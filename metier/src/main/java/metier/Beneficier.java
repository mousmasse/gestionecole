/**
 * 
 */
package metier;

/**
 * Classe Beneficier 
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class Beneficier {

	protected Eleve eleve;
	protected ServicesSup serviceSup;
	
	
	
	/**
	 * Constructeur sans paramètre
	 */
	public Beneficier() {
		super();
	}



	/**
	 * @param eleve
	 * @param serviceSup
	 */
	public Beneficier(Eleve eleve, ServicesSup serviceSup) {
		super();
		this.eleve = eleve;
		this.serviceSup = serviceSup;
	}



	/**
	 * @return the eleve
	 */
	public Eleve getEleve() {
		return eleve;
	}



	/**
	 * @param eleve the eleve to set
	 */
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}



	/**
	 * @return the serviceSup
	 */
	public ServicesSup getServiceSup() {
		return serviceSup;
	}


	/**
	 * @param serviceSup the serviceSup to set
	 */
	public void setServiceSup(ServicesSup serviceSup) {
		this.serviceSup = serviceSup;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Beneficier [eleve=" + eleve + ", serviceSup=" + serviceSup + "]";
	}
		
}
