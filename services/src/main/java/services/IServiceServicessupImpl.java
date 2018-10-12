/**
 * 
 */
package services;

import java.util.List;

import dao.IDaoServicessupImpl;
import metier.ServicesSup;


/**
 * Class IServiceServicessupImpl
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class IServiceServicessupImpl implements IServiceServicessup{
	
	private IDaoServicessupImpl iDaoServicessupImpl = new IDaoServicessupImpl();

	@Override
	public void ajouter(ServicesSup s) {

		iDaoServicessupImpl.ajouter(s);
	}

	@Override
	public List<ServicesSup> lire() {

		return iDaoServicessupImpl.lire();
	}

	@Override
	public void modifier(ServicesSup s) {
		
		iDaoServicessupImpl.modifier(s);
		
	}

	@Override
	public void supprimer(ServicesSup s) {

		iDaoServicessupImpl.supprimer(s);
		
	}

	@Override
	public ServicesSup dernierenregistrement() {

		return iDaoServicessupImpl.dernierenregistrement();
	}

	@Override
	public ServicesSup lire(ServicesSup e) {

		return iDaoServicessupImpl.lire(e);
	}

}
