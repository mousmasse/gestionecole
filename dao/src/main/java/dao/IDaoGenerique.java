/**
 * 
 */
package dao;

import java.util.List;

/**
 * Interface IDaoGenerique
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */

public interface IDaoGenerique <E>{
	
	/**
	 * @param e : Méthode générique pour l'ajout d'informations 
	 */
	public void ajouter(E e);
	
	/**
	 * @param e : Méthode générique pour la consultation d'informations 
	 */
	public E lire(E e);
	
	/**
	 * @param e : Méthode générique pour la consultation d'informations 
	 */
	public List<E> lire();
	
	/**
	 * @param e : Méthode générique pour la modification d'informations 
	 */
	public void modifier(E e);
	
	/**
	 * @param e : Méthode générique pour la suppression d'informations 
	 */
	public void supprimer(E e);
	
	/**
	 * @param e : Méthode générique pour récupérer le dernier enregistrement  
	 * @return 
	 */
	public  E  dernierenregistrement ();
}
