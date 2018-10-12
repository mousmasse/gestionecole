/**
 * 
 */
package services;

import metier.Beneficier;

/**
 * interface IServiceBeneficier
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public interface IServiceBeneficier extends IServiceGenerique<Beneficier>{

	/**
	 * @param e : Méthode générique pour la modification d'informations 
	 */
	public void modifier(Beneficier b1, Beneficier b2);
	
}
