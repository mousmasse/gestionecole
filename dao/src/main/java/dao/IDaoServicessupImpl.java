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


import metier.ServicesSup;
import utils.MysqlConnexion;

/**
 * IDaoServicessupImpl IDaoEleve
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class IDaoServicessupImpl implements IDaoServicessup {
	
	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	@Override
	public void ajouter(ServicesSup s) {
		//Etape1 : Création de la requête
		String sql = "INSERT INTO servicessup VALUES(NULL,?,?)";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
					
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setString(1, s.getLibelle_servicessup());
			preparedStatement.setDouble(2, s.getPrix_servicessup());
		
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion du service : "+ s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+" réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de l'insertion du service : " +s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+".");
		}
		
	}

	@Override
	public List<ServicesSup> lire() {
		List<ServicesSup> liste = new ArrayList<>();
		
		//Etape1 : Création de la requête
		String sql = "SELECT * FROM servicessup";
		
		try (Statement statement = connexion.createStatement()){
				
			//Etape2: Exécution de la requête
			try (ResultSet resultSet = statement.executeQuery(sql);){
				
				//Etape3 : Traitement du résultat
				while (resultSet.next()) {
					
					ServicesSup s = new ServicesSup();
					
					s.setId_servicessup(resultSet.getInt("id_servicessup"));
					s.setLibelle_servicessup(resultSet.getString("libelle_servicessup"));
					s.setPrix_servicessup(resultSet.getDouble("prix_servicessup"));
									
					liste.add(s);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la préparation de la liste des services supplémentaires.");
		}
		return liste;
	}

	@Override
	public void modifier(ServicesSup s) {
		//Etape1 : Création de la requête
		String sql = "UPDATE servicessup SET libelle_servicessup = ?, prix_servicessup=? WHERE id_servicessup=?";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
						
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setString(1, s.getLibelle_servicessup());
			preparedStatement.setDouble(2, s.getPrix_servicessup());
			preparedStatement.setInt(3, s.getId_servicessup());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Modification des informations de services supplémentaires : " +s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+ " réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la modification de services supplémentaires : "+ s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+".");
		}	
		
	}

	@Override
	public void supprimer(ServicesSup s) {
		//Etape1 : Création de la requête
		String sql = "DELETE FROM servicessup where id_servicessup=?";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){			
			//Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setInt(1, s.getId_servicessup());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression du service supplémentaire : "+ s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+" réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
	}

	@Override
	public ServicesSup dernierenregistrement() {
		ServicesSup s = new ServicesSup()
				;
		//Etape1 : Création de la requête
				String sql = "Select * from servicessup where id_servicessup = (SELECT MAX(id_servicessup)  from servicessup)";
				
		try (Statement statement = connexion.createStatement()){
			
		//Etape2: Exécution de la requête
		try (ResultSet resultSet = statement.executeQuery(sql)){
			
			//Etape3 : Traitement du résultat
			while (resultSet.next()) {
				
				s.setId_servicessup(resultSet.getInt("id_servicessup"));
				s.setLibelle_servicessup(resultSet.getString("libelle_servicessup"));
				s.setPrix_servicessup(resultSet.getDouble("prix_servicessup"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Echec de la récupération du dernier service enregistré.");
	}
		return s;
	}

	@Override
	public ServicesSup lire(ServicesSup s) {
		ServicesSup serviceSup = new ServicesSup();
		
		//Etape1 : Création de la requête
				String sql = "Select * from servicessup where libelle_servicessup = ?";
				
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
				
		//Etape2 : transmission de la valeur aux paramètres de la requête
		preparedStatement.setString(1, s.getLibelle_servicessup());
		
		//Etape3 : exécution de la requête
		
		try (ResultSet resultSet = preparedStatement.executeQuery()){
			
			//Etape3 : Traitement du résultat
			while (resultSet.next()) {
				
				serviceSup.setId_servicessup(resultSet.getInt("id_servicessup"));
				serviceSup.setLibelle_servicessup(resultSet.getString("libelle_servicessup"));
				serviceSup.setPrix_servicessup(resultSet.getDouble("prix_servicessup"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} catch (SQLException e1) {
		e1.printStackTrace();
		System.out.println("Echec de la récupération du service supplémentaire.");
	}
		return serviceSup;
	}

}
