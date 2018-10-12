/**
 * 
 */
package dao;


import metier.Beneficier;

/**
 * Interface IDaoBeneficier
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public interface IDaoBeneficier  extends IDaoGenerique<Beneficier>{

	/**
	 * @param e : Méthode générique pour la modification d'informations 
	 */
	public void modifier(Beneficier b1, Beneficier b2);
	
}