/**
 * 
 */
package metier;

import java.time.LocalDate;


/**
 * Classe Personne 
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */

public class Personne {
	


protected char sexe;
protected String prenom;
protected String nom;
protected LocalDate dateNaissance;
protected String lieuNaissance;
protected String adresse;
protected int telephone;
protected String email;

/**
 * Constructeur sans paramètres. 
 */
public Personne() {
	super();
}

/**
 * Constructeur avec paramètres.
 * @param sexe : homme h / H ; femme f / F
 * @param prenom : Le prénom
 * @param nom : Le nom
 * @param dateNaissance : La date de naissance
 * @param lieuNaissance : Le lieu de naissance
 * @param adresse : L'adresse de résidence
 * @param telephone : Le numéro de telephone
 * @param email : L'adresse email
 */
public Personne(char sexe, String prenom, String nom, LocalDate dateNaissance, String lieuNaissance, String adresse,
		int telephone, String email) {
	super();
	this.sexe = sexe;
	this.prenom = prenom;
	this.nom = nom;
	this.dateNaissance = dateNaissance;
	this.lieuNaissance = lieuNaissance;
	this.adresse = adresse;
	this.telephone = telephone;
	this.email = email;
}

/**
 * @return sexe : Retourne la valeur de la propriété sexe.
 */
public char getSexe() {
	return sexe;
}

/**
 * @param sexe : Mutation de la propriété sexe.
 */
public void setSexe(char sexe) {
	this.sexe = sexe;
}

/**
 * @return prenom : Retourne la valeur de la propriété prénom.
 */
public String getPrenom() {
	return prenom;
}

/**
 * @param prenom : Mutation de la propriété prénom.
 */
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

/**
 * @return nom : Retourne la valeur de la propriété nom.
 */
public String getNom() {
	return nom;
}

/**
 * @param nom : Mutation de la propriété nom.
 */
public void setNom(String nom) {
	this.nom = nom;
}

/**
 * @return dateNaissance : Retourne la valeur de la propriété date de naissance.
 */
public LocalDate getDateNaissance() {
	return dateNaissance;
}

/**
 * @param dateNaissance : Mutation de la propriété date de naissance.
 */
public void setDateNaissance(LocalDate datenaissance) {
	this.dateNaissance = datenaissance;
}

/**
 * @return lieuNaissance : Retourne la valeur de la propriété lieu de naissance.
 */
public String getLieuNaissance() {
	return lieuNaissance;
}

/**
 * @param lieuNaissance : Mutation de la propriété lieu de naissance.
 */
public void setLieuNaissance(String lieunaissance) {
	this.lieuNaissance = lieunaissance;
}

/**
 * @return adresse : Retourne la valeur de la propriété adresse.
 */
public String getAdresse() {
	return adresse;
}

/**
 * @param adresse : Mutation de la propriété adresse.
 */
public void setAdresse(String adresse) {
	this.adresse = adresse;
}

/**
 * @return telephone : Retourne la valeur de la propriété telephone.
 */
public int getTelephone() {
	return telephone;
}

/**
 * @param telephone : Mutation de la propriété telephone.
 */
public void setTelephone(int telephone) {
	this.telephone = telephone;
}

/**
 * @return email : Retourne la valeur de la propriété email.
 */
public String getEmail() {
	return email;
}

/**
 * @param email : Mutation de la propriété email.
 */
public void setEmail(String email) {
	this.email = email;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 * Redéfinition de la méthode toString() de la classe Object pour l'affichage de l'etat d'objet personne.
 */
@Override
public String toString() {
	return "Personne [Prenom =" + this.prenom + ", Nom =" + this.nom + ", Sexe =" + this.sexe + ", Date de naissance =" + this.dateNaissance
			+ ", Lieu de naissance =" + this.lieuNaissance + ", Adresse =" + this.adresse + ", Telephone =" + this.telephone + ", Email ="
			+ this.email + "]";
}


}