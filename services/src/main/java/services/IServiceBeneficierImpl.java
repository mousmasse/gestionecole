/**
 * 
 */
package services;

import java.util.List;

import dao.IDaoBeneficierImpl;
import metier.Beneficier;

/**
 * class IServiceBeneficierImpl
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class IServiceBeneficierImpl  implements IServiceBeneficier{
	
	IDaoBeneficierImpl iDaoBeneficierImpl = new IDaoBeneficierImpl();
	
	@Override
	public void ajouter(Beneficier b) {
		
		iDaoBeneficierImpl.ajouter(b);
	}

	@Override
	public List<Beneficier> lire() {
		
		return iDaoBeneficierImpl.lire();
	}

	@Override
	public void supprimer(Beneficier b) {
		iDaoBeneficierImpl.supprimer(b);
	}
	
	@Override
	public void modifier(Beneficier b1, Beneficier b2) {
		
		iDaoBeneficierImpl.modifier(b1, b2);
	}
	
	@Override
	public void modifier(Beneficier b) {
		// pas besoin :)
	}

	
	@Override
	public Beneficier dernierenregistrement() {
		// pas besoin :)
		return null;
	}

	@Override
	public Beneficier lire(Beneficier e) {
		// pas besoin :)
		return null;
	}

}
