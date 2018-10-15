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

import metier.Tuteur;
import utils.MysqlConnexion;

/**
 * class IDaoTuteurImpl
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */

public class IDaoTuteurImpl implements IDaoTuteur {

	Connection connexion = MysqlConnexion.getInstanceConnexion();
	
	@Override
	public void ajouter(Tuteur t) {

		//Etape1 : Création de la requête
		String sql = "INSERT INTO tuteur VALUES(NULL,?,?,?,?,?)";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
						
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setString(1, t.getNom());
			preparedStatement.setString(2, t.getPrenom());
			preparedStatement.setInt(3, t.getTelephone());
			preparedStatement.setString(4, t.getEmail());
			preparedStatement.setString(5, t.getAdresse());
					
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion du tuteur : "+ t.getPrenom()+" "+ t.getNom()+" réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de l'insertion du tuteur : "+ t.getPrenom()+" "+ t.getNom()+".");
		}
	
	}

	@Override
	public List<Tuteur> lire() {
		List<Tuteur> listeTuteur = new ArrayList<>();
		
		//Etape1 : Création de la requête
		String sql = "SELECT * FROM tuteur";
		
		try (Statement statement = connexion.createStatement()){
			
			//Etape2: Exécution de la requête
			try (ResultSet resultSet = statement.executeQuery(sql)){
				
				//Etape3 : Traitement du résultat
				while (resultSet.next()) {
					
					Tuteur t = new Tuteur();
					
					t.setIdTuteur(resultSet.getInt("id_tuteur")); 
					t.setNom(resultSet.getString("nom_tuteur")); 
					t.setPrenom(resultSet.getString("prenom_tuteur")); 
					t.setAdresse(resultSet.getString("adresse_tuteur"));  
					t.setTelephone(resultSet.getInt("telephonne_tuteur")); 
					t.setEmail(resultSet.getString("email_tuteur")); 
					
					listeTuteur.add(t);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la préparation de la liste des tuteurs.");
		}
		return listeTuteur;
	}

	@Override
	public void modifier(Tuteur t) {
		//Etape1 : Création de la requête
		String sql = "UPDATE tuteur SET prenom_tuteur = ?, nom_tuteur=?, telephonne_tuteur =?, email_tuteur =?, adresse_tuteur =? WHERE id_tuteur=?";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
					
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setString(1, t.getNom());
			preparedStatement.setString(2, t.getPrenom());
			preparedStatement.setInt(3, t.getTelephone());
			preparedStatement.setString(4, t.getEmail());
			preparedStatement.setString(5, t.getAdresse());
			preparedStatement.setInt(6, t.getIdTuteur());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Modification des informations du tuteur : " + t.getPrenom() + " " + t.getNom() + " réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la modification des informations du tuteur : "+ t.getPrenom()+" "+ t.getNom()+".");
		}
		
	}

	@Override
	public void supprimer(Tuteur t) {

		//Etape1 : Création de la requête
		String sql = "DELETE FROM tuteur where id_tuteur=?";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
			
			//Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setInt(1, t.getIdTuteur());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression du tuteur : "+ t.getPrenom()+" "+ t.getNom()+" réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
		
	}

	@Override
	public  Tuteur dernierenregistrement() {
		
		Tuteur t = new Tuteur();
		
		//Etape1 : Création de la requête
		String sql = "Select * from tuteur where id_tuteur = (SELECT MAX(id_tuteur)  from tuteur)";
		
		try (Statement statement = connexion.createStatement()){
						
			//Etape2: Exécution de la requête
			try(ResultSet resultSet = statement.executeQuery(sql)) {

				//Etape3 : Traitement du résultat
				while (resultSet.next()) {
					t.setIdTuteur(resultSet.getInt("id_tuteur")); 
					t.setNom(resultSet.getString("nom_tuteur")); 
					t.setPrenom(resultSet.getString("prenom_tuteur")); 
					t.setAdresse(resultSet.getString("adresse_tuteur"));  
					t.setTelephone(resultSet.getInt("telephonne_tuteur")); 
					t.setEmail(resultSet.getString("email_tuteur")); 
										
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la préparation de la liste des tuteurs.");
		}
		return t;
		
	}

	@Override
	public Tuteur lire(Tuteur t) {
		
		Tuteur tuteur = new Tuteur();
		
		//Etape1 : Création de la requête
				String sql = "Select * from tuteur where id_tuteur = ?";
				
				
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
		
		//Etape2 : transmission de la valeur aux paramètres de la requête
		preparedStatement.setInt(1, t.getIdTuteur());
		
		//Etape3 : exécution de la requête
		try (ResultSet resultSet = preparedStatement.executeQuery()){
			
			//Etape3 : Traitement du résultat
			while (resultSet.next()) {
				
				tuteur.setIdTuteur(resultSet.getInt("id_tuteur")); 
				tuteur.setNom(resultSet.getString("nom_tuteur")); 
				tuteur.setPrenom(resultSet.getString("prenom_tuteur")); 
				tuteur.setAdresse(resultSet.getString("adresse_tuteur"));  
				tuteur.setTelephone(resultSet.getInt("telephonne_tuteur")); 
				tuteur.setEmail(resultSet.getString("email_tuteur")); 
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (SQLException e1) {
		e1.printStackTrace();
		System.out.println("Echec de la récupération du tuteur.");
	}
		return tuteur;
	}

	

}
