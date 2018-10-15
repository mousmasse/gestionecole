/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Beneficier;
import metier.Eleve;
import metier.ServicesSup;
import utils.MysqlConnexion;

/**
 * class IDaoBeneficierImpl
 * @author Moustapha M. NDIAYE
 * @version  1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class IDaoBeneficierImpl implements IDaoBeneficier{

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */  
	Connection connexion = MysqlConnexion.getInstanceConnexion();
	
	@Override
	public void ajouter(Beneficier b) {
		//Etape1 : Création de la requête
		String sql = "INSERT INTO beneficier VALUES(?,?)";
		
		try(PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setInt(1, b.getEleve().getIdEleve());
			preparedStatement.setInt(2, b.getServiceSup().getId_servicessup());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Prise en compte du service pour: l'élève "+ b.getEleve().getPrenom()+" "+ b.getEleve().getNom()+" réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la prise en compte du service pour l'élève : "+b.getEleve().getPrenom()+" "+ b.getEleve().getNom()+".");
		}
		
	}

	@Override
	public List<Beneficier> lire() {
		
		List<Beneficier> liste = new ArrayList<>();
		//Etape1 : Création de la requête
		String sql = "SELECT * FROM beneficier";
		
		try (Statement statement = connexion.createStatement()){
			
			//Etape2: Exécution de la requête
			try (ResultSet resultSet = statement.executeQuery(sql);){
				
				//Etape3 : Traitement du résultat
				while (resultSet.next()) {
					
					Beneficier b = new Beneficier();
					Eleve e = new Eleve();
					ServicesSup s = new ServicesSup();
					
					e.setIdEleve(resultSet.getInt("id_eleve"));
					s.setId_servicessup(resultSet.getInt("id_servicessup"));
					b.setEleve(e);
					b.setServiceSup(s);
					
					liste.add(b);
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la préparation de la liste des éléves bénéficiaires.");
		}
		return liste;
	}

	
	@Override
	public void supprimer(Beneficier b) {
		//Etape1 : Création de la requête
		String sql = "DELETE FROM beneficier where (id_eleve=? && id_servicessup=?)";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
						
			//Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setInt(1, b.getEleve().getIdEleve());
			preparedStatement.setInt(2,b.getServiceSup().getId_servicessup());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
	}

	
	@Override
	public void modifier(Beneficier b1, Beneficier b2) {
		//Etape1 : Création de la requête
		String sql = "UPDATE beneficier SET id_eleve=?, id_servicessup=? WHERE (id_eleve=? && id_servicessup=?)";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
					
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setInt(1, b2.getEleve().getIdEleve());
			preparedStatement.setInt(2,b2.getServiceSup().getId_servicessup());
			preparedStatement.setInt(3, b1.getEleve().getIdEleve());
			preparedStatement.setInt(4,b1.getServiceSup().getId_servicessup());
						
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Modification réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la modification.");
		}	
		
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
	@Override
	public void modifier(Beneficier b) {
		// pas besoin :)
	}


}
