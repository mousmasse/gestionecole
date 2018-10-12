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


import metier.Eleve;
import utils.MysqlConnexion;

/**
 * class IDaoEleveImpl
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */

public class IDaoEleveImpl implements IDaoEleve{
	
	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	@Override
	public void ajouter(Eleve e) {
		try {
			//Etape1 : Création de la requête
			String sql = "INSERT INTO eleve VALUES(NULL,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setString(1, e.getNom());
			preparedStatement.setString(2, e.getPrenom());
			preparedStatement.setDate(3, Date.valueOf(e.getDateNaissance()));
			preparedStatement.setString(4, e.getLieuNaissance());
			preparedStatement.setString(5, String.valueOf(e.getSexe()));
			preparedStatement.setString(6, e.getAdresse());
			preparedStatement.setInt(7, e.getTelephone());
			preparedStatement.setString(8, e.getEmail());
			preparedStatement.setInt(9, e.getIdTuteur());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion de l'élève : "+ e.getPrenom()+" "+ e.getNom()+" réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de l'insertion de l'élève : "+ e.getPrenom()+" "+ e.getNom()+".");
		}
		
	}

	@Override
	public List<Eleve> lire() {
		List<Eleve> liste = new ArrayList<>();
		
		try {
			//Etape1 : Création de la requête
			String sql = "SELECT * FROM eleve";
			Statement statement = connexion.createStatement();
			
			//Etape2: Exécution de la requête
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du résultat
			while (resultSet.next()) {
				
				Eleve e = new Eleve();
				
				e.setIdEleve(resultSet.getInt("id_eleve")); 
				e.setNom(resultSet.getString("nom_eleve")); 
				e.setPrenom(resultSet.getString("prenom_eleve")); 
				Date date = resultSet.getDate("date_naissance_eleve");
				e.setDateNaissance(date.toLocalDate()); 
				e.setLieuNaissance(resultSet.getString("lieu_naissance_eleve"));   
				e.setSexe( resultSet.getString("sexe_eleve").charAt(0));  
				e.setAdresse(resultSet.getString("adresse_eleve"));  
				e.setTelephone(resultSet.getInt("telephonne_eleve")); 
				e.setEmail(resultSet.getString("email_eleve")); 
				e.setIdTuteur(resultSet.getInt("id_tuteur"));
				
				liste.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la préparation de la liste des éléves.");
		}
		return liste;
	}

	@Override
	public void modifier(Eleve e) {

		try {
			//Etape1 : Création de la requête
			String sql;
			if (e.getIdTuteur()>0) {
				sql = "UPDATE eleve SET nom_eleve = ?, prenom_eleve=?, date_naissance_eleve =?, lieu_naissance_eleve =?, sexe_eleve =?, adresse_eleve =?, telephonne_eleve =?, email_eleve =?, id_tuteur =? WHERE id_eleve=?";
			}else {
				sql = "UPDATE eleve SET nom_eleve = ?, prenom_eleve=?, date_naissance_eleve =?, lieu_naissance_eleve =?, sexe_eleve =?, adresse_eleve =?, telephonne_eleve =?, email_eleve =? WHERE id_eleve=?";
			}
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux paramètres de la requête
			preparedStatement.setString(1, e.getNom());
			preparedStatement.setString(2, e.getPrenom());
			preparedStatement.setDate(3, Date.valueOf(e.getDateNaissance()));
			preparedStatement.setString(4, e.getLieuNaissance());
			preparedStatement.setString(5, String.valueOf(e.getSexe()));
			preparedStatement.setString(6, e.getAdresse());
			preparedStatement.setInt(7, e.getTelephone());
			preparedStatement.setString(8, e.getEmail());
			if (e.getIdTuteur()>0) {
				preparedStatement.setInt(9, e.getIdTuteur());
				preparedStatement.setInt(10, e.getIdEleve());
			}else {
				preparedStatement.setInt(9, e.getIdEleve());
			}
			
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Modification des informations de l'élève : " + e.getPrenom() + " " + e.getNom() + " réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la modification des informations de l'élève : "+ e.getPrenom()+" "+ e.getNom()+".");
		}	
	}

	@Override
	public void supprimer(Eleve e) {
		
		try {
			//Etape1 : Création de la requête
			String sql = "DELETE FROM eleve where id_eleve=?";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setInt(1, e.getIdEleve());
			
			//Etape3 : exécution de la requête
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression de l'élève : réussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
	}

	@Override
	public Eleve dernierenregistrement() {
		Eleve eleve = new Eleve();
			try {
			//Etape1 : Création de la requête
			String sql = "Select * from eleve where id_eleve = (SELECT MAX(id_eleve)  from eleve)";
			Statement statement = connexion.createStatement();
			
			//Etape2: Exécution de la requête
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du résultat
			while (resultSet.next()) {
				
			
				eleve.setIdEleve(resultSet.getInt("id_eleve")); 
				eleve.setNom(resultSet.getString("nom_eleve")); 
				eleve.setPrenom(resultSet.getString("prenom_eleve")); 
				Date date = resultSet.getDate("date_naissance_eleve");
				eleve.setDateNaissance(date.toLocalDate()); 
				eleve.setLieuNaissance(resultSet.getString("lieu_naissance_eleve"));   
				eleve.setSexe( resultSet.getString("sexe_eleve").charAt(0));  
				eleve.setAdresse(resultSet.getString("adresse_eleve"));  
				eleve.setTelephone(resultSet.getInt("telephonne_eleve")); 
				eleve.setEmail(resultSet.getString("email_eleve")); 
				eleve.setIdTuteur(resultSet.getInt("id_tuteur"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la récupération du dernier eleve enregistré.");
		}
		return eleve;
	}

	@Override
	public Eleve lire(Eleve e) {
		Eleve eleve = new Eleve();
		try {
		//Etape1 : Création de la requête
		String sql = "Select * from eleve where id_eleve = ?";
		PreparedStatement preparedStatement = connexion.prepareStatement(sql);
		
		//Etape2 : transmission de la valeur aux paramètres de la requête
		preparedStatement.setInt(1, e.getIdEleve());
		
		//Etape3 : exécution de la requête
		ResultSet resultSet = preparedStatement.executeQuery();
		
		//Etape3 : Traitement du résultat
		while (resultSet.next()) {
			
			eleve.setIdEleve(resultSet.getInt("id_eleve")); 
			eleve.setNom(resultSet.getString("nom_eleve")); 
			eleve.setPrenom(resultSet.getString("prenom_eleve")); 
			Date date2=resultSet.getDate("date_naissance_eleve");
			eleve.setDateNaissance(date2.toLocalDate()); 
			eleve.setLieuNaissance(resultSet.getString("lieu_naissance_eleve"));   
			eleve.setSexe( resultSet.getString("sexe_eleve").charAt(0));  
			eleve.setAdresse(resultSet.getString("adresse_eleve"));  
			eleve.setTelephone(resultSet.getInt("telephonne_eleve")); 
			eleve.setEmail(resultSet.getString("email_eleve")); 
			eleve.setIdTuteur(resultSet.getInt("id_tuteur"));
			
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
		System.out.println("Echec de la récupération de l'eleve.");
	}
	return eleve;
	}

	
	

}
