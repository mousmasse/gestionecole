/**
 * 
 */
package services;

import java.util.List;

import dao.IDaoAdministrationImpl;
import metier.Administration;

/**
 * Class IserviceAdministrationImpl
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class IServiceAdministrationImpl implements IServiceAdministration{

	private IDaoAdministrationImpl iDaoAdminImpl = new IDaoAdministrationImpl();
	
	@Override
	public void ajouter(Administration a) {
		
		iDaoAdminImpl.ajouter(a);		
	}

	@Override
	public List<Administration> lire() {
		
		return iDaoAdminImpl.lire();
	}

	@Override
	public void modifier(Administration a) {
		
		iDaoAdminImpl.modifier(a);
		
	}

	@Override
	public void supprimer(Administration a) {
		
		iDaoAdminImpl.supprimer(a);
		
	}

	@Override
	public Administration dernierenregistrement() {

		return iDaoAdminImpl.dernierenregistrement();
	}

	@Override
	public Administration lire(Administration a) {
		// TODO Auto-generated method stub
		return null;
	}

}
