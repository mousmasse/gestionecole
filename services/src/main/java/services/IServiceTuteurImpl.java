/**
 * 
 */
package services;


import java.util.List;


import dao.IDaoTuteurImpl;
import metier.Tuteur;

/**
 * Class IServiceTuteurImpl
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class IServiceTuteurImpl implements IServiceTuteur{

	private IDaoTuteurImpl iDaoTuteurImpl = new IDaoTuteurImpl();
	
	@Override
	public void ajouter(Tuteur t) {
		iDaoTuteurImpl.ajouter(t);
		
	}

	@Override
	public List<Tuteur> lire() {
		return iDaoTuteurImpl.lire();
	}

	@Override
	public void modifier(Tuteur t) {
		
		iDaoTuteurImpl.modifier(t);
		
	}

	@Override
	public void supprimer(Tuteur t) {

		iDaoTuteurImpl.supprimer(t);
		
	}

	@Override
	public Tuteur dernierenregistrement() {

		return iDaoTuteurImpl.dernierenregistrement();
	}

	@Override
	public Tuteur lire(Tuteur t) {
		return iDaoTuteurImpl.lire(t);
	}

}
