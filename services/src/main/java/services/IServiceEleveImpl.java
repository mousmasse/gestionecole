/**
 * 
 */
package services;

import java.util.List;

import dao.IDaoEleveImpl;
import metier.Eleve;

/**
 * Class IServiceEleveImpl
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */

public class IServiceEleveImpl implements IServiceEleve {

	private IDaoEleveImpl iDaoEleve = new IDaoEleveImpl();
	
	@Override
	public void ajouter(Eleve e) {

		iDaoEleve.ajouter(e);
		
	}

	@Override
	public List<Eleve> lire() {

		return iDaoEleve.lire();
	}

	@Override
	public void modifier(Eleve e) {
		
		iDaoEleve.modifier(e);
		
	}

	@Override
	public void supprimer(Eleve e) {
		
		iDaoEleve.supprimer(e);
		
	}

	@Override
	public Eleve dernierenregistrement() {
		
		return iDaoEleve.dernierenregistrement();
	}

	@Override
	public Eleve lire(Eleve e) {

		return iDaoEleve.lire(e);
	}

	
	
}
