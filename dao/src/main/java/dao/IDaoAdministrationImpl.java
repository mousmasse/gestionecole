/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Administration;
import utils.MysqlConnexion;

/**
 * class IDaoAdministrationImpl
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */
public class IDaoAdministrationImpl implements IDaoAdministration{

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();
	
	
	@Override
	public void ajouter(Administration a) {
		PreparedStatement preparedStatement = null; 
		try {
			//Etape1 : Création de la requête
			String sql = "INSERT INTO administration VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?)";
			 preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setString(1, a.getPrenom());
			preparedStatement.setString(2, a.getNom());
			preparedStatement.setDate(3, Date.valueOf(a.getDateNaissance()));
			preparedStatement.setString(4, a.getLieuNaissance());
			preparedStatement.setString(5, String.valueOf(a.getSexe()));
			preparedStatement.setString(6, a.getAdresse());
			preparedStatement.setInt(7, a.getTelephone());
			preparedStatement.setString(8, a.getEmail());
			preparedStatement.setDate(9, Date.valueOf(a.getDateRecrutementAdministration()));
			preparedStatement.setInt(10, a.getIdProfession());
			preparedStatement.setInt(11, a.getIdDiplome());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion de lagent de l'administration :  réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de l'insertion de lagent de l'administration.");
		}try {
			preparedStatement.close();
			System.out.println("Fermeture preparedStatement(ajouter) adminstration :  réussit.");
		} catch (SQLException e) {
			System.out.println("Echec fermeture preparedStatement(ajouter) adminstration.");
			e.printStackTrace();
		} finally {
			System.out.println("Fin traitement ajouter adminstration.");
		}
				
		
		
	}

	@Override
	public Administration lire(Administration a) {
		Administration admin = new Administration();
		PreparedStatement preparedStatement = null;
		try {
			//Etape1 : Création de la requête
			String sql = "SELECT * FROM administration where id_administration = ?";
			 
			 preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setInt(1, a.getIdAdministration());
			
			//Etape3 : exécution de la requête
			ResultSet resultSet = preparedStatement.executeQuery();
			
			 
			//Etape3 : Traitement du résultat
			while (resultSet.next()) {
								
				
				
				admin.setIdAdministration(resultSet.getInt("id_administration")); 
				admin.setNom(resultSet.getString("nom_administration")); 
				admin.setPrenom(resultSet.getString("prenom_administration")); 
				Date date = resultSet.getDate("date_naissance_administration");
				admin.setDateNaissance(date.toLocalDate()); 
				admin.setLieuNaissance(resultSet.getString("lieu_naissance_administration"));   
				admin.setSexe( resultSet.getString("sexe_administration").charAt(0));  
				admin.setAdresse(resultSet.getString("adresse_administration"));  
				admin.setTelephone(resultSet.getInt("telephonne_administration")); 
				admin.setEmail(resultSet.getString("email_administration")); 
				date = resultSet.getDate("date_recrutement_administration");
				admin.setDateRecrutementAdministration(date.toLocalDate()); 
				admin.setIdProfession(resultSet.getInt("id_profession"));
				admin.setIdDiplome(resultSet.getInt("id_diplome"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la préparation des informations de l'agent de l'administration.");
		}try {
			preparedStatement.close();
			System.out.println("Fermeture preparedStatement(lire) adminstration :  réussit.");
		} catch (SQLException e) {
			System.out.println("Echec fermeture preparedStatement(lire) adminstration.");
			e.printStackTrace();
		} finally {
			System.out.println("Fin traitement lire adminstration.");
		}
		
		return admin;
	}

	@Override
	public List<Administration> lire() {
List<Administration> listeAdmin = new ArrayList<>();
Statement statement = null;
		try {
			//Etape1 : Création de la requête
			String sql = "SELECT * FROM administration";
			 statement = connexion.createStatement();
			
			//Etape2: Exécution de la requête
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du résultat
			while (resultSet.next()) {
				
				Administration admin = new Administration(); 
				
				admin.setIdAdministration(resultSet.getInt("id_administration")); 
				admin.setNom(resultSet.getString("nom_administration")); 
				admin.setPrenom(resultSet.getString("prenom_administration")); 
				Date date = resultSet.getDate("date_naissance_administration");
				admin.setDateNaissance(date.toLocalDate()); 
				admin.setLieuNaissance(resultSet.getString("lieu_naissance_administration"));   
				admin.setSexe( resultSet.getString("sexe_administration").charAt(0));  
				admin.setAdresse(resultSet.getString("adresse_administration"));  
				admin.setTelephone(resultSet.getInt("telephonne_administration")); 
				admin.setEmail(resultSet.getString("email_administration")); 
				date = resultSet.getDate("date_recrutement_administration");
				admin.setDateRecrutementAdministration(date.toLocalDate()); 
				admin.setIdProfession(resultSet.getInt("id_profession"));
				admin.setIdDiplome(resultSet.getInt("id_diplome"));
				
				listeAdmin.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la préparation de la liste des agents de l'administration.");
		}try {
				statement.close();
			System.out.println("Fermeture statement(liste) adminstration :  réussit.");
		} catch (SQLException e) {
			System.out.println("Echec fermeture statement(liste) adminstration.");
			e.printStackTrace();
		} finally {
			System.out.println("Fin traitement liste adminstration.");
		}
		return listeAdmin;
	}

	@Override
	public void modifier(Administration a) {
		PreparedStatement preparedStatement = null;
		try {
			//Etape1 : Création de la requête
			String sql = "UPDATE administration SET prenom_administration = ?, nom_administration=?, date_naissance_administration =?, lieu_naissance_administration =?, sexe_administration =?, adresse_administration =?, telephonne_administration =?, email_administration =?, date_recrutement_administration =?, id_profession=?, id_diplome=? WHERE id_administration=?";
			 preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setString(1, a.getPrenom());
			preparedStatement.setString(2, a.getNom());
			preparedStatement.setDate(3, Date.valueOf(a.getDateNaissance()));
			preparedStatement.setString(4, a.getLieuNaissance());
			preparedStatement.setString(5, String.valueOf(a.getSexe()));
			preparedStatement.setString(6, a.getAdresse());
			preparedStatement.setInt(7, a.getTelephone());
			preparedStatement.setString(8, a.getEmail());
			preparedStatement.setDate(9, Date.valueOf(a.getDateRecrutementAdministration()));
			preparedStatement.setInt(10, a.getIdProfession());
			preparedStatement.setInt(11, a.getIdDiplome());
			preparedStatement.setInt(12, a.getIdAdministration());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Modification des informations de l'agent de l'administration réussit.");
			
		} catch (SQLException e1) {
			System.out.println("Echec de la modification des informations de l'agent de l'administration.");
			e1.printStackTrace();			
		}try {
			preparedStatement.close();
			System.out.println("Fermeture preparedStatement(modifier) adminstration :  réussit.");
		} catch (SQLException e) {
			System.out.println("Echec fermeture preparedStatement(modifier) adminstration.");
			e.printStackTrace();
		} finally {
			System.out.println("Fin traitement modifier adminstration.");
		}
		
	}

	@Override
	public void supprimer(Administration a) {
		PreparedStatement preparedStatement = null;
		try {
			//Etape1 : Création de la requête
			String sql = "DELETE FROM administration where id_administration=?";
			 preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setInt(1, a.getIdAdministration());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression de l'agent de l'administration réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();			
		}try {
			preparedStatement.close();
			System.out.println("Fermeture preparedStatement(supprimer) adminstration :  réussit.");
		} catch (SQLException e) {
			System.out.println("Echec fermeture preparedStatement(supprimer) adminstration.");
			e.printStackTrace();
		} finally {
			System.out.println("Fin traitement supprimer adminstration.");
		}
		
	}

	@Override
	public Administration dernierenregistrement() {
		Administration adminlast = new Administration();
		Statement statement = null;
		try {
			//Etape1 : Création de la requête
			String sql = "Select * from administration where id_administration = (SELECT MAX(id_administration)  from administration)";
			 statement = connexion.createStatement();
			
			//Etape2: Exécution de la requête
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du résultat
			while (resultSet.next()) {
				
			
				adminlast.setIdAdministration(resultSet.getInt("id_administration")); 
				adminlast.setNom(resultSet.getString("nom_administration")); 
				adminlast.setPrenom(resultSet.getString("prenom_administration")); 
				Date date = resultSet.getDate("date_naissance_administration");
				adminlast.setDateNaissance(date.toLocalDate()); 
				adminlast.setLieuNaissance(resultSet.getString("lieu_naissance_administration"));   
				adminlast.setSexe( resultSet.getString("sexe_administration").charAt(0));  
				adminlast.setAdresse(resultSet.getString("adresse_administration"));  
				adminlast.setTelephone(resultSet.getInt("telephonne_administration")); 
				adminlast.setEmail(resultSet.getString("email_administration")); 
				date = resultSet.getDate("date_recrutement_administration");
				adminlast.setDateRecrutementAdministration(date.toLocalDate()); 
				adminlast.setIdProfession(resultSet.getInt("id_profession"));
				adminlast.setIdDiplome(resultSet.getInt("id_diplome"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la récupération du dernier agent administratif enregistré.");
		}try {
			statement.close();
		System.out.println("Fermeture statement(dernierenregistrement) adminstration :  réussit.");
	} catch (SQLException e) {
		System.out.println("Echec fermeture statement(dernierenregistrement) adminstration.");
		e.printStackTrace();
	} finally {
		System.out.println("Fin traitement dernierenregistrement adminstration.");
	}

		return adminlast;
	}

}