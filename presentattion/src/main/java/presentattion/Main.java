/**
 * 
 */
package presentattion;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import metier.Administration;
import metier.Beneficier;
import metier.Eleve;
import metier.ServicesSup;
import metier.Tuteur;
import services.IServiceBeneficierImpl;
import services.IServiceEleveImpl;
import services.IServiceServicessupImpl;
import services.IServiceTuteurImpl;
import services.IServiceAdministrationImpl;

/**
 * Class Main
 * 
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018
 */
public class Main {

	/**
	 * Méthode main, point d'entré du projet.
	 * 
	 * @param args : Variable arguments
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Eleve eleve = new Eleve();
		Tuteur tuteur = new Tuteur();
		Administration agentAdmin =  new Administration();
		IServiceEleveImpl iserviceEleveImpl = new IServiceEleveImpl();
		IServiceTuteurImpl servTutImpl = new IServiceTuteurImpl();
		IServiceAdministrationImpl iserviceAdminImpl = new IServiceAdministrationImpl();
		IServiceServicessupImpl iServiceServiceSupImpl = new IServiceServicessupImpl();
		IServiceBeneficierImpl iServiceBeneficierImpl = new IServiceBeneficierImpl();
		// Comptabilite compta = new Comptabilite();
		int tache = 0;
		char reponse = 'n';

		System.out.println("*********** Bienvenue!!! ***********");
		System.out.println("La gestion informatisée est de plus en plus courante\r\n"
				+ "dans notre société, le secteur éducatif n’échappe pas à\r\n" + "cette tendance.\r\n "
				+ "Nous sommes présence d'une application de gestion scolaire.\r\n"
				+ "Elle à pour cible les écoles du cycle primaire.");
		System.out.println("********************************************");

		do {
			int menuEleve = 0;
			int menuadmin = 0;

			do {
				System.out.println("Veuillez trouver ci-dessous les actions possibles regrouper en menu.");
				System.out.println("1 = Administration");
				System.out.println("2 = Elève");
				System.out.println("3 = Quitter");
				System.out.println("_____________________________________________________________________________");

				System.out.println("Quel tâche voullez vous effectuer???");
				try {
					tache = sc.nextInt();

				} catch (InputMismatchException e) {
					System.out.println("Entrée incorrecte; Veuillez choisir parmi les actions possibles.");
					sc.nextLine();
				}
			} while (tache <= 0 || tache > 3);

			switch (tache) {
			case 1:

				do {
					System.out.println("Veuillez trouver ci-dessous les actions possibles pour le menu administration.");
					System.out.println("1 = Ajouter un agent");
					System.out.println("2 = Modifier un agent");
					System.out.println("3 = Supprimer un agent");
					System.out.println("4 = Retour au menu principal");
					System.out.println("_____________________________________________________________________________");

					System.out.println("Quel action voullez vous effectuer???");

					try {
						menuadmin = sc.nextInt();

						switch (menuadmin) {
						case 1:
							
							System.out.println("*********** AJOUTER UN AGENT ***********");
							System.out.println("Les informations à fournir pour un agent sont:");
							System.out.println("" + "Le prénom\r\n" + "Le nom\r\n" + "La date de naissance\r\n"
									+ "Le lieu de naissance\r\n" + "sexe : homme h / H ; femme f / F \r\n"
									+ "L'adresse de résidence\r\n" + "Le numéro de telephone\r\n"
									+ "L'adresse email\r\n" + "La fonction\r\n" + "Le diplome\r\n" );
							System.out.println("_____________________________________________________________________________");
 
							sc.nextLine();

							do {
								System.out.println("Donnez le prénom de l'agent");
								agentAdmin.setPrenom(sc.nextLine());
							} while (agentAdmin.getPrenom().trim().length() < 4);

							do {
								System.out.println("Donnez le nom de famille de " + agentAdmin.getPrenom());
								agentAdmin.setNom(sc.nextLine());
							} while (agentAdmin.getNom().length() < 2);

							do {
								System.out.println("Donnez la date de naissance de " + agentAdmin.getPrenom() + " "
										+ agentAdmin.getNom() + " (Format de la date jour-mois-année ou 01-10-2001)");
								String date = sc.nextLine();
								String datej = null;
								String datem = null;
								String datea = null;
								try {
									datej = date.substring(0, 2);
									datem = date.substring(3, 5);
									datea = date.substring(6);
									date = datea + "-" + datem + "-" + datej;
								} catch (Exception e1) {
									System.out.println("Veuillez respecter le format demandé.");
									date = null;
								}

								if (date != null) {
									LocalDate localDate = null;
									try {
										localDate = LocalDate.parse(date);
									} catch (Exception e) {
										System.out.println("Donnez une date de naissance valide");
									}
									agentAdmin.setDateNaissance(localDate);
								}
							} while (agentAdmin.getDateNaissance() == null);

							do {
								System.out.println("Donnez le lieu de naissance de " + agentAdmin.getPrenom() + " " + agentAdmin.getNom());
								agentAdmin.setLieuNaissance(sc.nextLine());
							} while (agentAdmin.getLieuNaissance().length() < 3);

							char scRep = 'n';
							do {
								System.out.println("Renseigner le sexe : homme h / H ou femme f / F ");
								try {
									scRep = sc.nextLine().charAt(0);
									if (scRep == 'h' || scRep == 'H' || scRep == 'F' || scRep == 'f') {
										agentAdmin.setSexe(scRep);
									} else {
										scRep = 'n';
									}
								} catch (StringIndexOutOfBoundsException e) {
									System.out.println("Saisie incorrecte!!!");
									scRep = 'n';
								}
							} while (scRep == 'n');

							do {
								System.out.println(
										"Donnez l'adresse de résidence de " + agentAdmin.getPrenom() + " " + agentAdmin.getNom());
								agentAdmin.setAdresse(sc.nextLine());
							} while (agentAdmin.getAdresse().length() < 3);

							do {
								System.out.println("Donnez le numéro de telephone de " + agentAdmin.getPrenom() + " "
										+ agentAdmin.getNom() + ".(ex:776250778); (Obligatoir)");
								agentAdmin.setTelephone(sc.nextInt());
							} while (agentAdmin.getTelephone() < 0 || agentAdmin.getTelephone() > 999999999);
							sc.nextLine();
							do {
								System.out.println("Donnez l'adresse email de " + agentAdmin.getPrenom() + " " + agentAdmin.getNom() );
								agentAdmin.setEmail(sc.nextLine());
							} while (agentAdmin.getEmail().length() < 3);

							char fonctionRep = 'n';
							do {
								System.out.println("Donnez la fonction de l'agent (DIRECTEUR - SURVEILLANT - SECRETAIRE - COMPTABLE - HYGIENE -GARDIEN)");
								String fonction = sc.nextLine();
								if (fonction.trim().toUpperCase().equals("DIRECTEUR")) {
									agentAdmin.setIdProfession(1);
									fonctionRep = 'O';
								} else if (fonction.trim().toUpperCase().equals("SURVEILLANT")) {
									agentAdmin.setIdProfession(2);
									fonctionRep = 'O';
								} else if (fonction.trim().toUpperCase().equals("SECRETAIRE")) {
									agentAdmin.setIdProfession(3);
									fonctionRep = 'O';
								} else if (fonction.trim().toUpperCase().equals("COMPTABLE")) {
									agentAdmin.setIdProfession(4);
									fonctionRep = 'O';
								} else if (fonction.trim().toUpperCase().equals("HYGIENE")) {
									agentAdmin.setIdProfession(5);
									fonctionRep = 'O';
								} else if (fonction.trim().toUpperCase().equals("GARDIEN")) {
									agentAdmin.setIdProfession(6);
									fonctionRep = 'O';
								}

							} while (fonctionRep == 'n');

							char diplomRep = 'n';
							do {
								System.out.println("Donnez le diplome de l'agent (LICENCE - MASTER - DOCTORAT)");
								String diplome = sc.nextLine();
								if (diplome.trim().toUpperCase().equals("LICENCE")) {
									agentAdmin.setIdDiplome(1);
									diplomRep = 'O';
								} else if (diplome.trim().toUpperCase().equals("MASTER")) {
									agentAdmin.setIdDiplome(2);
									diplomRep = 'O';
								} else if (diplome.trim().toUpperCase().equals("DOCTORAT")) {
									agentAdmin.setIdDiplome(3);
									diplomRep = 'O';
								} 
							} while (diplomRep == 'n');

							
							System.out.println("\r____________________________________________________");
							System.out.println("\rPRESENTATION DES INFORMATIONS DE L'AGENT");
							System.out.println("\r____________________________________________________");
							agentAdmin.setDateRecrutementAdministration(LocalDate.now());
							System.out.println(agentAdmin.toString());
							
							System.out.println("Insertion de lagent");
							iserviceAdminImpl.ajouter(agentAdmin);
							
							break;

						case 2:

							System.out.println("*********** MODIFIER UN AGENT ***********");
							System.out.println("Les informations à modifier pour un agent sont:");
							System.out.println("" + "Le prénom\r\n" + "Le nom\r\n" + "La date de naissance\r\n"
									+ "Le lieu de naissance\r\n" + "sexe : homme h / H ; femme f / F \r\n"
									+ "L'adresse de résidence\r\n" + "Le numéro de telephone\r\n"
									+ "L'adresse email\r\n" + "La fonction\r\n" + "Le diplome\r\n" );

							sc.nextLine();
							char agentRep = 'z';
							List<Administration> listeAdmin = new ArrayList<>();
							listeAdmin = iserviceAdminImpl.lire();
							int idAgentRep;
							if (listeAdmin.size()>0) {
								System.out.println("***********Liste des agents ***********");
								listeAdmin.stream().forEach(System.out::println);
								System.out.println("***************************************");
								idAgentRep = 0;
								Administration agentAdministration = new Administration();
								do {
									System.out.println("Donnez Le numéro d'identification l'agent depuis la liste.");
									try {
										idAgentRep = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
										System.out.println(
												"Donnez uniquement le numéro d'identification de l'agent depuis la liste.");
									}
									Integer intAgRep = idAgentRep;
									agentAdministration.setIdAdministration(listeAdmin.stream()
											.filter((a) -> a.getIdAdministration() == intAgRep.intValue()).findFirst()
											.map(Administration::getIdAdministration).orElse(-1));

									if (agentAdministration.getIdAdministration() <= 0) {
										System.out.println(
												"Le numéro d'identification choisie ne figure pas dans la liste.");
										agentRep = 'z';
									}
								} while (agentAdministration.getIdAdministration() <= 0);
								agentAdmin = new Administration();
								agentAdmin = iserviceAdminImpl.lire(agentAdministration);
								do {
									System.out.println("Donnez le prénom de l'agent");
									agentAdministration.setPrenom(sc.nextLine());
								} while (agentAdministration.getPrenom().trim().length() < 4);
								do {
									System.out.println("Donnez le nom de famille de l'agent");
									agentAdministration.setNom(sc.nextLine());
								} while (agentAdministration.getNom().length() < 2);
								agentAdministration.setDateNaissance(null);
								do {
									System.out.println(
											"Donnez la date de naissance de l'agent (Format de la date jour-mois-année ou 01-10-2001)");
									String date = sc.nextLine();
									String datej = null;
									String datem = null;
									String datea = null;
									try {
										datej = date.substring(0, 2);
										datem = date.substring(3, 5);
										datea = date.substring(6);
										date = datea + "-" + datem + "-" + datej;
									} catch (Exception e1) {
										System.out.println("Veuillez respecter le format demandé.");
										date = null;
									}

									if (date != null) {
										LocalDate localDate = null;
										try {
											localDate = LocalDate.parse(date);
										} catch (Exception e) {
											System.out.println("Donnez une date de naissance valide");
										}
										agentAdministration.setDateNaissance(localDate);
									}
								} while (agentAdministration.getDateNaissance() == null);
								do {
									System.out.println("Donnez le lieu de naissance ");
									agentAdministration.setLieuNaissance(sc.nextLine());
								} while (agentAdministration.getLieuNaissance().length() < 3);
								scRep = 'n';
								do {
									System.out.println("Renseigner le sexe : homme h / H ou femme f / F ");
									try {
										scRep = sc.nextLine().charAt(0);
										if (scRep == 'h' || scRep == 'H' || scRep == 'F' || scRep == 'f') {
											agentAdministration.setSexe(scRep);
										} else {
											scRep = 'n';
										}
									} catch (StringIndexOutOfBoundsException e) {
										System.out.println("Saisie incorrecte!!!");
										scRep = 'n';
									}
								} while (scRep == 'n');
								do {
									System.out.println("Donnez l'adresse de résidence");
									agentAdministration.setAdresse(sc.nextLine());
								} while (agentAdministration.getAdresse().length() < 3);
								do {
									System.out.println("Donnez le numéro de telephone");
									agentAdministration.setTelephone(sc.nextInt());
								} while (agentAdministration.getTelephone() < 0
										|| agentAdministration.getTelephone() > 999999999);
								sc.nextLine();
								do {
									System.out.println("Donnez l'adresse email");
									agentAdministration.setEmail(sc.nextLine());
								} while (agentAdministration.getEmail().length() < 3);
								fonctionRep = 'n';
								do {
									System.out.println(
											"Donnez la fonction de l'agent (DIRECTEUR - SURVEILLANT - SECRETAIRE - COMPTABLE - HYGIENE -GARDIEN)");
									String fonction = sc.nextLine();
									if (fonction.trim().toUpperCase().equals("DIRECTEUR")) {
										agentAdministration.setIdProfession(1);
										fonctionRep = 'O';
									} else if (fonction.trim().toUpperCase().equals("SURVEILLANT")) {
										agentAdministration.setIdProfession(2);
										fonctionRep = 'O';
									} else if (fonction.trim().toUpperCase().equals("SECRETAIRE")) {
										agentAdministration.setIdProfession(3);
										fonctionRep = 'O';
									} else if (fonction.trim().toUpperCase().equals("COMPTABLE")) {
										agentAdministration.setIdProfession(4);
										fonctionRep = 'O';
									} else if (fonction.trim().toUpperCase().equals("HYGIENE")) {
										agentAdministration.setIdProfession(5);
										fonctionRep = 'O';
									} else if (fonction.trim().toUpperCase().equals("GARDIEN")) {
										agentAdministration.setIdProfession(6);
										fonctionRep = 'O';
									}

								} while (fonctionRep == 'n');
								diplomRep = 'n';
								do {
									System.out.println("Donnez le diplome de l'agent (LICENCE - MASTER - DOCTORAT)");
									String diplome = sc.nextLine();
									if (diplome.trim().toUpperCase().equals("LICENCE")) {
										agentAdministration.setIdDiplome(1);
										diplomRep = 'O';
									} else if (diplome.trim().toUpperCase().equals("MASTER")) {
										agentAdministration.setIdDiplome(2);
										diplomRep = 'O';
									} else if (diplome.trim().toUpperCase().equals("DOCTORAT")) {
										agentAdministration.setIdDiplome(3);
										diplomRep = 'O';
									}
								} while (diplomRep == 'n');
								System.out.println("\r______________________________________________________________");
								System.out.print("\rPRESENTATION DES INFORMATIONS DE L'AGENT APRES MODIFICATION");
								System.out.println("\r_______________________________________________________________");
								agentAdministration.setDateRecrutementAdministration(LocalDate.now());
								System.out.println(agentAdministration.toString());
								System.out.println("Modification des information de  l'agent");
								iserviceAdminImpl.modifier(agentAdministration);
							}else {
								System.out.println("Pas d'agent deja enregistre pour une modification.");
							}
							break;

						case 3:

							System.out.println("*********** SUPPRIMER UN AGENT ***********");
							sc.nextLine();
							int ct=0;
							reponse='x';
							agentRep = 'z';
							listeAdmin = new ArrayList<>();
							listeAdmin = iserviceAdminImpl.lire();
							System.out.println("*********** Liste des eleves ***********");
							
							if (listeAdmin.size()>0) {
								listeAdmin.stream().forEach(System.out::println);
								System.out.println("***************************************");
								idAgentRep = 0;
								Administration adminSup = new Administration();
								do {
									System.out.println("Donnez Le numéro d'identification de l'agent depuis la liste.");
									try {
										idAgentRep = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
										System.out.println(
												"Donnez uniquement le numéro d'identification de l'agent depuis la liste.");
									}
									Integer intAdRep = idAgentRep;
									adminSup.setIdAdministration(listeAdmin.stream()
											.filter((a) -> a.getIdAdministration() == intAdRep.intValue()).findFirst()
											.map(Administration::getIdAdministration).orElse(-1));
									if (adminSup.getIdAdministration() <= 0) {
										System.out.println(
												"Le numéro d'identification choisie ne figure pas dans la liste.");
										agentRep = 'z';
										if (ct >= 3) {
											do {
												System.out
														.println("Voullez vous rester sur le menu suppression :( ???");
												System.out.println("O ou N");
												try {
													reponse = sc.nextLine().charAt(0);
													if (reponse == 'O' || reponse == 'o') {
														break;
													}
													if (reponse == 'N' || reponse == 'n') {
														ct = 0;
													}
												} catch (StringIndexOutOfBoundsException e) {
													System.out.println("Saisie incorrecte!!!");
												}
											} while (ct == 3);

										}
									} else {
										agentRep = 'y';
									}
									ct++;
									if (reponse == 'O' || reponse == 'o') {
										break;
									}
								} while (agentRep == 'z');
								if (adminSup.getIdAdministration() != -1) {
									iserviceAdminImpl.supprimer(adminSup);
									System.out.println(
											"\r______________________________________________________________");
									System.out.println("\rPRESENTATION DES INFORMATIONS DE L'ELEVE APRES SUPPRESSION");
									System.out.println(
											"\r_______________________________________________________________");
									listeAdmin = iserviceAdminImpl.lire();
									listeAdmin.stream().forEach(System.out::println);
								} 
							}else {
								System.out.println("Pas d'agent deja enregistre pour une modification.");
							}
							break;

						case 4:
							System.out.println("*********** Retour au menu principal ***********");
							menuEleve = 99;
							break;
						default:
							System.out.println("Entrée incorrecte; Veuillez choisir parmi les actions possibles.");
							break;
						}

					} catch (InputMismatchException e) {
						System.out.println("Entrée incorrecte; Veuillez choisir parmi les actions possibles.");
						sc.nextLine();
					}
					if (menuEleve == 99) {
						reponse = 'O';
						break;
					}
				} while (menuEleve <= 0 || menuEleve > 4);

				break;

			case 2:

				do {
					System.out.println("Veuillez trouver ci-dessous les actions possibles pour le menu eleve.");
					System.out.println("1 = Ajouter un eleve");
					System.out.println("2 = Modifier un eleve");
					System.out.println("3 = Supprimer un eleve");
					System.out.println("4 = Retour au menu principal");
					System.out.println("_____________________________________________________________________________");

					System.out.println("Quel action voullez vous effectuer???");
					try {
						menuEleve = sc.nextInt();

						switch (menuEleve) {
						case 1:
							
							System.out.println("*********** AJOUTER UN ELEVE ***********");
							System.out.println("Les informations à fournir pour l'élève sont:");
							System.out.println("" + "Le prénom\r\n" + "Le nom\r\n" + "La date de naissance\r\n"
									+ "Le lieu de naissance\r\n" + "sexe : homme h / H ; femme f / F \r\n"
									+ "L'adresse de résidence\r\n" + "Le numéro de telephone\r\n"
									+ "L'adresse email\r\n" + "Classe : CI - CP - CE1 - CE2 - CM1 -CM2\r\n"
									+ "Prénom de la personne en charge de l'éléve\r\n"
									+ "Nom de la personne en charge de l'éléve"
									+ "Email de la personne en charge de l'éléve"
									+ "Le numéro de telephone de la personne en charge de l'éléve\r\n"
									+ "Si oui (O/o) ou non (N/n) l'éléve prend le bus de l'école ?\r\n"
									+ "Si oui (O/o) ou non (N/n)  l'éléve prend le déjeuner à la cantine de l'école ?");
							System.out.println(
									"_____________________________________________________________________________");

							sc.nextLine();

							do {
								System.out.println("Donnez le prénom de l'élève");
								eleve.setPrenom(sc.nextLine());
							} while (eleve.getPrenom().trim().length() < 4);

							do {
								System.out.println("Donnez le nom de famille de " + eleve.getPrenom());
								eleve.setNom(sc.nextLine());
							} while (eleve.getNom().length() < 2);

							do {
								System.out.println("Donnez la date de naissance de " + eleve.getPrenom() + " "
										+ eleve.getNom() + " (Format de la date jour-mois-année ou 01-10-2001)");
								String date = sc.nextLine();
								String datej = null;
								String datem = null;
								String datea = null;
								try {
									datej = date.substring(0, 2);
									datem = date.substring(3, 5);
									datea = date.substring(6);
									date = datea + "-" + datem + "-" + datej;
								} catch (Exception e1) {
									System.out.println("Veuillez respecter le format demandé.");
									date = null;
								}

								if (date != null) {
									LocalDate localDate = null;
									try {
										localDate = LocalDate.parse(date);
									} catch (Exception e) {
										System.out.println("Donnez une date de naissance valide");
									}
									eleve.setDateNaissance(localDate);
								}
							} while (eleve.getDateNaissance() == null);

							do {
								System.out.println(
										"Donnez le lieu de naissance de " + eleve.getPrenom() + " " + eleve.getNom());
								eleve.setLieuNaissance(sc.nextLine());
							} while (eleve.getLieuNaissance().length() < 3);

							char scRep = 'n';
							do {
								System.out.println("Renseigner le sexe : homme h / H ou femme f / F ");
								try {
									scRep = sc.nextLine().charAt(0);
									if (scRep == 'h' || scRep == 'H' || scRep == 'F' || scRep == 'f') {
										eleve.setSexe(scRep);
									} else {
										scRep = 'n';
									}
								} catch (StringIndexOutOfBoundsException e) {
									System.out.println("Saisie incorrecte!!!");
									scRep = 'n';
								}
							} while (scRep == 'n');

							do {
								System.out.println(
										"Donnez l'adresse de résidence de " + eleve.getPrenom() + " " + eleve.getNom());
								eleve.setAdresse(sc.nextLine());
							} while (eleve.getAdresse().length() < 3);

							do {
								System.out.println("Donnez le numéro de telephone de " + eleve.getPrenom() + " "
										+ eleve.getNom() + ".(ex:776250778); Si l'eleve n'a pas de numéro mettez : 0.");
								eleve.setTelephone(sc.nextInt());
							} while (eleve.getTelephone() < 0 || eleve.getTelephone() > 999999999);
							sc.nextLine();
							do {
								System.out.println("Donnez l'adresse email de " + eleve.getPrenom() + " "
										+ eleve.getNom() + "; Si l'eleve n'a pas d'email mettez : neant.");
								eleve.setEmail(sc.nextLine());
							} while (eleve.getEmail().length() < 3);

							char classeRep = 'n';
							do {
								System.out.println("Donnez la classe (CI - CP - CE1 - CE2 - CM1 -CM2) de l'éléve "+ eleve.getPrenom() + " " + eleve.getNom());
								String classe = sc.nextLine();
								if (classe.trim().toUpperCase().equals("CI")) {
									classeRep = 'O';
								} else if (classe.trim().toUpperCase().equals("CP")) {
									classeRep = 'O';
								} else if (classe.trim().toUpperCase().equals("CE1")) {
									classeRep = 'O';
								} else if (classe.trim().toUpperCase().equals("CE2")) {
									classeRep = 'O';
								} else if (classe.trim().toUpperCase().equals("CM1")) {
									classeRep = 'O';
								} else if (classe.trim().toUpperCase().equals("CM2")) {
									classeRep = 'O';
								}

							} while (classeRep == 'n');

							char tuteurRep = 'z';
							int idTuteurRep = 0;
							do {
								List<Tuteur> listeTuteur = new ArrayList<>();
								Stream<Tuteur> streamTuteur1, streamTuteur2;
								tuteur.setIdTuteur(0);
								System.out.println("Est-ce que la personne en charge de l'élève " + eleve.getPrenom()
										+ " " + eleve.getNom() + " est déjà tuteur d'un élève inscrit O/N ?");
								try {
									tuteurRep = sc.nextLine().charAt(0);
								} catch (StringIndexOutOfBoundsException e) {
									e.printStackTrace();
								}
								if (tuteurRep == 'o' || tuteurRep == 'O') {

									listeTuteur = servTutImpl.lire();

									if (listeTuteur.size() > 0) {

										streamTuteur1 = listeTuteur.stream();
										streamTuteur1.forEach(System.out::println);

										do {
											System.out.println(
													"Le numéro d'identification de la personne en charge de l'élève depuis la liste.");
											try {
												idTuteurRep = Integer.parseInt(sc.nextLine());
											} catch (NumberFormatException e) {
												System.out.println(
														"Donnez uniquement le numéro d'identification de la personne en charge de l'élève depuis la liste.");
											}
											streamTuteur2 = listeTuteur.stream();
											Integer intRep = idTuteurRep;
											tuteur.setIdTuteur(
													streamTuteur2.filter((t) -> t.getIdTuteur() == intRep.intValue())
															.findFirst().map(Tuteur::getIdTuteur).orElse(-1));
											if (tuteur.getIdTuteur() <= 0) {
												System.out.println(
														"Le numéro d'identification choisie ne figure pas dans la liste.");
												tuteurRep = 'z';
												break;
											}
										} while (tuteur.getIdTuteur() < 0);
									} else {
										tuteurRep = 'n';
									}
								} else if (tuteurRep == 'n' || tuteurRep == 'N') {
									String numTest = null;
									do {
										System.out.println("Prénom de la personne en charge de l'éléve "
												+ eleve.getPrenom() + " " + eleve.getNom());
										tuteur.setPrenom(sc.nextLine());
									} while (tuteur.getPrenom().length() < 2);
									do {
										System.out.println("Nom de la personne en charge de l'éléve "
												+ eleve.getPrenom() + " " + eleve.getNom());
										tuteur.setNom(sc.nextLine());
									} while (tuteur.getNom().length() < 2);
									do {
										System.out.println("Le numéro de telephone de la personne en charge de l'éléve "
												+ eleve.getPrenom() + " " + eleve.getNom() + " Obligatoire");
										numTest = sc.nextLine();
										if (numTest.length() == 9) {
											try {
												tuteur.setTelephone(0);
												tuteur.setTelephone(Integer.parseInt(numTest));
											} catch (NumberFormatException e) {
												System.out.println(
														"Le numéro de telephone ne doit pas comporter de lettres");
											}
										} else {
											tuteur.setTelephone(-1);
										}
									} while (tuteur.getTelephone() < 0);
									sc.nextLine();
									do {
										System.out.println("Email de la personne en charge de l'éléve "
												+ eleve.getPrenom() + " " + eleve.getNom()
												+ "; Si le tuteur n'a pas d'email mettez : neant.");
										tuteur.setEmail(sc.nextLine());
									} while (tuteur.getEmail().length() < 3);

								} else {
									tuteurRep = 'z';
								}
							} while (tuteurRep == 'z');

							List<ServicesSup> listeServices = new ArrayList<>();
							ServicesSup serviceCantine = new ServicesSup();
							ServicesSup serviceTransport = new ServicesSup();
							listeServices = iServiceServiceSupImpl.lire();
							Stream<ServicesSup> streamServicesSup = listeServices.stream();
							streamServicesSup.forEach(System.out::println);
							System.out.println("Ci-dessus la liste des services supplémentaires prévu par l'établissement.");
							sc.nextLine();
							char optRep = 'b';
							do {
								System.out.println("Est ce que l'élève " + eleve.getPrenom() + " " + eleve.getNom()
										+ " va prendre le bus de l'école? (O/o) ou non (N/n) ");
								try {
									optRep = sc.nextLine().charAt(0);
									if (optRep == 'o' || optRep == 'O' || optRep == 'N' || optRep == 'n') {
										char question = optRep;
										if (question == 'O' || question == 'o') {
											serviceTransport.setLibelle_servicessup("TRANSPORT");
											serviceTransport = iServiceServiceSupImpl.lire(serviceTransport);
										} else {
											serviceTransport = null;
										}
									} else {
										optRep = 'b';
									}
								} catch (StringIndexOutOfBoundsException e) {
									System.out.println("Saisie incorrecte!!!");
									optRep = 'b';
								}
							} while (optRep == 'b');

							sc.nextLine();
							optRep = 'b';
							do {
								System.out.println("Est ce que l'élève " + eleve.getPrenom() + " " + eleve.getNom()
										+ " va manger à la cantine de l'école? (O/o) ou non (N/n) ");
								try {
									optRep = sc.nextLine().charAt(0);
									if (optRep == 'o' || optRep == 'O' || optRep == 'N' || optRep == 'n') {
										char question = optRep;
										if (question == 'O' || question == 'o') {
											serviceCantine.setLibelle_servicessup("CANTINE");
											serviceCantine = iServiceServiceSupImpl.lire(serviceCantine);
										} else {
											serviceCantine = null;
										}
									} else {
										optRep = 'b';
									}
								} catch (StringIndexOutOfBoundsException e) {
									System.out.println("Saisie incorrecte!!!");
									optRep = 'b';
								}
							} while (optRep == 'b');

							System.out.println("\r____________________________________________________");
							System.out.println("\rPRESENTATION DES INFORMATIONS DE L'ELEVE");
							System.out.println("\r____________________________________________________");
							System.out.println(eleve.toString());
							if (tuteur.getIdTuteur() > 0) {
								eleve.setIdTuteur(tuteur.getIdTuteur());
							} else {
								System.out.println("Prise en compte du tuteur");
								servTutImpl.ajouter(tuteur);
								tuteur = null;
								tuteur = servTutImpl.dernierenregistrement();
								System.out.println("Id du nouveau Tuteur");
								System.out.println(tuteur);
							}

							System.out.println("Insertion de l'éléve");
							eleve.setIdTuteur(tuteur.getIdTuteur());
							iserviceEleveImpl.ajouter(eleve);

							if (serviceCantine != null || serviceTransport != null) {
								System.out.println("Prise en compte des services supplémentaire pour l'eleve ");
								eleve = iserviceEleveImpl.dernierenregistrement();
								Beneficier beneficier = new Beneficier();
								beneficier.setEleve(eleve);
								if (serviceCantine != null) {

									beneficier.setServiceSup(serviceCantine);
									iServiceBeneficierImpl.ajouter(beneficier);

								}
								if (serviceTransport != null) {

									beneficier.setServiceSup(serviceTransport);
									iServiceBeneficierImpl.ajouter(beneficier);
								}
								
								if (serviceTransport == null && serviceCantine == null) {
									System.out.println("Pas de services supplementaire prise en compte pour l'eleve apres modification.");
								}

							}
							break;

						case 2:

							System.out.println("*********** MODIFIER UN ELEVE ***********");
							System.out.println("Les informations à modifier pour l'élève sont:");
							System.out.println("" + "Le prénom\r\n" + "Le nom\r\n" + "La date de naissance\r\n"
									+ "Le lieu de naissance\r\n" + "sexe : homme h / H ; femme f / F \r\n"
									+ "L'adresse de résidence\r\n" + "Le numéro de telephone\r\n"
									+ "L'adresse email\r\n" + "Classe : CI - CP - CE1 - CE2 - CM1 -CM2\r\n"
									+ "Prénom de la personne en charge de l'éléve\r\n"
									+ "Nom de la personne en charge de l'éléve"
									+ "Email de la personne en charge de l'éléve"
									+ "Le numéro de telephone de la personne en charge de l'éléve\r\n"
									+ "Si oui (O/o) ou non (N/n) l'éléve prend le bus de l'école ?\r\n"
									+ "Si oui (O/o) ou non (N/n)  l'éléve prend le déjeuner à la cantine de l'école ?");

							sc.nextLine();
							char eleveRep = 'z';
							List<Eleve> listeEleve = new ArrayList<>();
							listeEleve = iserviceEleveImpl.lire();
							System.out.println("***********Liste des eleves ***********");
							listeEleve.stream().forEach(System.out::println);
							System.out.println("***************************************");
							int idEleveRep = 0;
							Eleve modifEleve = new Eleve();
							do {
								System.out.println("Donnez Le numéro d'identification l'élève depuis la liste.");
								try {
									idEleveRep = Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									System.out.println(
											"Donnez uniquement le numéro d'identification de l'élève depuis la liste.");
								}
								Integer intRep = idEleveRep;
								modifEleve.setIdEleve(listeEleve.stream().filter((e) -> e.getIdEleve() == intRep.intValue()).findFirst().map(Eleve::getIdEleve).orElse(-1));
								if (modifEleve.getIdEleve() <= 0) {
									System.out
											.println("Le numéro d'identification choisie ne figure pas dans la liste.");
									eleveRep = 'z';
								}
							} while (modifEleve.getIdEleve()<=0);

								eleve = null;
								eleve = iserviceEleveImpl.lire(modifEleve);
							do {
								System.out.println("Donnez le prénom de l'élève (Ancienne valeur: "+eleve.getPrenom()+")");
								modifEleve.setPrenom(sc.nextLine());
							} while (modifEleve.getPrenom().trim().length() < 4);

							do {
								System.out.println("Donnez le nom de famille de l'eleve (Ancienne valeur: "+eleve.getNom()+")");
								modifEleve.setNom(sc.nextLine());
							} while (modifEleve.getNom().length() < 2);
							modifEleve.setDateNaissance(null);
							DateTimeFormatter dateFormater =DateTimeFormatter.ofPattern("dd-MM-YYYY"); 
							do {
								System.out.println("Donnez la date de naissance de l'eleve (Ancienne valeur: "+dateFormater.format(eleve.getDateNaissance())+") (Format de la date jour-mois-année ou 01-10-2001)");
								String date = sc.nextLine();
								String datej = null;
								String datem = null;
								String datea = null;
								try {
									datej = date.substring(0, 2);
									datem = date.substring(3, 5);
									datea = date.substring(6);
									date = datea + "-" + datem + "-" + datej;
								} catch (Exception e1) {
									System.out.println("Veuillez respecter le format demandé.");
									date = null;
								}

								if (date != null) {
									LocalDate localDate = null;
									try {
										localDate = LocalDate.parse(date);
									} catch (Exception e) {
										System.out.println("Donnez une date de naissance valide");
									}
									modifEleve.setDateNaissance(localDate);
								}
							} while (modifEleve.getDateNaissance() == null);
							do {
								System.out.println(
										"Donnez le lieu de naissance (Ancienne valeur: "+eleve.getLieuNaissance()+")");
								modifEleve.setLieuNaissance(sc.nextLine());
							} while (modifEleve.getLieuNaissance().length() < 3);
							scRep = 'n';
							do {
								System.out.println("Renseigner le sexe : homme h / H ou femme f / F (Ancienne valeur: "+eleve.getSexe()+")");
								try {
									scRep = sc.nextLine().charAt(0);
									if (scRep == 'h' || scRep == 'H' || scRep == 'F' || scRep == 'f') {
										modifEleve.setSexe(scRep);
									} else {
										scRep = 'n';
									}
								} catch (StringIndexOutOfBoundsException e) {
									System.out.println("Saisie incorrecte!!!");
									scRep = 'n';
								}
							} while (scRep == 'n');
							
							do {
								System.out.println("Donnez l'adresse de résidence (Ancienne valeur: "+eleve.getAdresse()+")");
								modifEleve.setAdresse(sc.nextLine());
							} while (modifEleve.getAdresse().length() < 3);

							do {
								System.out.println("Donnez le numéro de telephone (Ancienne valeur: "+eleve.getTelephone()+").(ex:776250778); Si l'eleve n'a pas de numéro mettez : 0.");
								modifEleve.setTelephone(sc.nextInt());
							} while (modifEleve.getTelephone() < 0 || modifEleve.getTelephone() > 999999999);
							sc.nextLine();
							do {
								System.out.println("Donnez l'adresse email (Ancienne valeur: "+eleve.getEmail()+"); Si l'eleve n'a pas d'email mettez : neant.");
								modifEleve.setEmail(sc.nextLine());
							} while (modifEleve.getEmail().length() < 3);

							classeRep = 'n';
							do {
								System.out.println("Donnez la classe (CI - CP - CE1 - CE2 - CM1 -CM2) de l'éléve (Ancienne valeur: "+eleve.getClass()+")");
								String classe = sc.nextLine();
								switch (classe.toUpperCase()) {
								case "CI": classeRep = 'O';
									break;
								case "CP": classeRep = 'O';
								break;
								case "CE1": classeRep = 'O';
								break;
								case "CE2": classeRep = 'O';
								break;
								case "CM1": classeRep = 'O';
								break;
								case "CM2": classeRep = 'O';
								break;
								default: classeRep = 'n';
									break;
								}

							} while (classeRep == 'n');

							tuteurRep = 'z';
							idTuteurRep = 0;
							tuteur.setIdTuteur(eleve.getIdTuteur());
							tuteur = servTutImpl.lire(tuteur);
							System.out.println("Le tuteur en charge de l'éléve");
							System.out.println(tuteur);
							System.out.println("Voulez vous changer le tuteur ? O/N");
							try {
								tuteurRep = sc.nextLine().charAt(0);
							} catch (StringIndexOutOfBoundsException e) {
								e.printStackTrace();
							}
								idTuteurRep=-1;
								if (tuteurRep == 'o' || tuteurRep == 'O') {
									tuteur=new Tuteur();
									do {
										System.out.println("Voulez vous changer le tuteur par un personne déjà tuteur d'un élève inscrit ? O/N");
										try {
											tuteurRep = sc.nextLine().charAt(0);
										} catch (StringIndexOutOfBoundsException e) {
											e.printStackTrace();
										}
										
										if (tuteurRep == 'o' || tuteurRep == 'O') {
											List<Tuteur> listeTuteur = new ArrayList<>();
											tuteur.setIdTuteur(0);
											listeTuteur = servTutImpl.lire();

											if (listeTuteur.size() > 0) {

												listeTuteur.stream().forEach(System.out::println);

												do {
													System.out.println("Le numéro d'identification de la personne en charge de l'élève depuis la liste ci-dessus.");
													try {
														idTuteurRep = Integer.parseInt(sc.nextLine());
													} catch (NumberFormatException e) {
														System.out.println("Donnez uniquement le numéro d'identification de la personne en charge de l'élève depuis la liste.");
														tuteurRep = 'z';
														System.out.println("idTuteurRep dans catch = "+idTuteurRep);
													}
													
													System.out.println("idTuteurRep apres try-catch = "+idTuteurRep);
													Integer intRep = idTuteurRep;
													tuteur.setIdTuteur(listeTuteur.stream().filter((t) -> t.getIdTuteur() == intRep.intValue()).findFirst().map(Tuteur::getIdTuteur).orElse(-1));
													System.out.println("Résultat stream modif tuteur = " + tuteur.getIdTuteur());
													if (tuteur.getIdTuteur() <= 0) {
														System.out.println(
																"Le numéro d'identification choisie ne figure pas dans la liste.");
														tuteurRep = 'z';
													}
													tuteurRep = 'O';
												} while (tuteur.getIdTuteur() < 0);
												modifEleve.setIdTuteur(tuteur.getIdTuteur());
											} else {
												tuteurRep = 'n';
											}
										} else if (tuteurRep == 'n' || tuteurRep == 'N') {

											String numTest = null;
											do {
												System.out.println("Prénom de la personne en charge de l'éléve");
												tuteur.setPrenom(sc.nextLine());
											} while (tuteur.getPrenom().length() < 2);
											do {
												System.out.println("Nom de la personne en charge de l'éléve");
												tuteur.setNom(sc.nextLine());
											} while (tuteur.getNom().length() < 2);
											do {
												System.out.println(
														"Le numéro de telephone de la personne en charge de l'éléve Obligatoire");
												numTest = sc.nextLine();
												if (numTest.length() == 9) {
													try {
														tuteur.setTelephone(0);
														tuteur.setTelephone(Integer.parseInt(numTest));
													} catch (NumberFormatException e) {
														System.out.println(
																"Le numéro de telephone ne doit pas comporter de lettres");
													}
												} else {
													tuteur.setTelephone(-1);
												}
											} while (tuteur.getTelephone() < 0);
											sc.nextLine();
											do {
												System.out.println(
														"Email de la personne en charge de l'éléve; Si le tuteur n'a pas d'email mettez : neant.");
												tuteur.setEmail(sc.nextLine());
											} while (tuteur.getEmail().length() < 3);
											System.out.println("Prise en compte du tuteur");
											servTutImpl.ajouter(tuteur);
											tuteur = null;
											tuteur = servTutImpl.dernierenregistrement();
											System.out.println("Recapitulatif nouveau Tuteur");
											System.out.println(tuteur);
											modifEleve.setIdTuteur(tuteur.getIdTuteur());
										} else {
											tuteurRep = 'z';
										}
									} while (tuteurRep == 'z');
								} 
							serviceCantine = new ServicesSup();
							serviceTransport = new ServicesSup();
							listeServices = iServiceServiceSupImpl.lire();
							System.out.println();
							listeServices.stream().forEach(System.out::println);
							System.out.println();
							System.out.println("Ci-dessus la liste des services supplémentaires prévu par l'établissement.");							
							optRep = 'b';
							do {
								System.out.println("Est ce que l'élève " + modifEleve.getPrenom() + " " + modifEleve.getNom()
										+ " va prendre le bus de l'école? (O/o) ou non (N/n) ");
								try {
									optRep = sc.nextLine().charAt(0);
									if (optRep == 'o' || optRep == 'O' || optRep == 'N' || optRep == 'n') {
										char question = optRep;
										if (question == 'O' || question == 'o') {
											serviceTransport.setLibelle_servicessup("TRANSPORT");
											serviceTransport = iServiceServiceSupImpl.lire(serviceTransport);
										} else {
											serviceTransport = null;
										}
									} else {
										optRep = 'b';
									}
								} catch (StringIndexOutOfBoundsException e) {
									System.out.println("Saisie incorrecte!!!");
									optRep = 'b';
								}
							} while (optRep == 'b');

							optRep = 'b';
							do {
								System.out.println("Est ce que l'élève " + modifEleve.getPrenom() + " " + modifEleve.getNom()
										+ " va manger à la cantine de l'école? (O/o) ou non (N/n) ");
								try {
									optRep = sc.nextLine().charAt(0);
									if (optRep == 'o' || optRep == 'O' || optRep == 'N' || optRep == 'n') {
										char question = optRep;
										if (question == 'O' || question == 'o') {
											serviceCantine.setLibelle_servicessup("CANTINE");
											serviceCantine = iServiceServiceSupImpl.lire(serviceCantine);
										} else {
											serviceCantine = null;
										}
									} else {
										optRep = 'b';
									}
								} catch (StringIndexOutOfBoundsException e) {
									System.out.println("Saisie incorrecte!!!");
									optRep = 'b';
								}
							} while (optRep == 'b');
							
							System.out.println("\r______________________________________________________________");
							System.out.print("\rPRESENTATION DES INFORMATIONS DE L'ELEVE APRES MODIFICATION");
							System.out.println("\r_______________________________________________________________");
							System.out.println(modifEleve.toString());
							System.out.println("Modification des information de  l'éléve");
							iserviceEleveImpl.modifier(modifEleve);
							
							if (serviceCantine != null || serviceTransport != null) {
								System.out.println("Prise en compte des services supplémentaire pour l'eleve apres modification.");

								Beneficier beneficier = new Beneficier();
								beneficier.setEleve(modifEleve);
								if (serviceCantine != null) {
									
									beneficier.setServiceSup(serviceCantine);
									iServiceBeneficierImpl.supprimer(beneficier);
									iServiceBeneficierImpl.ajouter(beneficier);

								}
								if (serviceTransport != null) {

									beneficier.setServiceSup(serviceTransport);
									iServiceBeneficierImpl.supprimer(beneficier);
									iServiceBeneficierImpl.ajouter(beneficier);
								} 
								
								if (serviceTransport == null && serviceCantine == null) {
									System.out.println("Pas de services supplementaire prise en compte pour l'eleve apres modification.");
								}

							}
							
							break;

						case 3:

							System.out.println("*********** SUPPRIMER UN ELEVE ***********");
							sc.nextLine();
							int ct=0;
							reponse='x';
							eleveRep = 'z';
							listeEleve = new ArrayList<>();
							listeEleve = iserviceEleveImpl.lire();
							System.out.println("*********** Liste des eleves ***********");
							listeEleve.stream().forEach(System.out::println);
							System.out.println("***************************************");
							idEleveRep = 0;
							Eleve eleveSup = new Eleve();
							do {
								System.out.println("Donnez Le numéro d'identification l'élève depuis la liste.");
								try {
									idEleveRep = Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									System.out.println("Donnez uniquement le numéro d'identification de l'élève depuis la liste.");
								}
								Integer intRep = idEleveRep;
								eleveSup.setIdEleve(listeEleve.stream().filter((e) -> e.getIdEleve() == intRep.intValue()).findFirst().map(Eleve::getIdEleve).orElse(-1));
								if (eleveSup.getIdEleve() <= 0) {
									System.out.println("Le numéro d'identification choisie ne figure pas dans la liste.");
									eleveRep = 'z';
									if (ct>=3) {
										do {
											System.out.println("Voullez vous le menu suppression :( ???");
											System.out.println("O ou N");
											try {
												reponse = sc.nextLine().charAt(0);
												if (reponse == 'O' || reponse == 'o') {
													break;
												}
												if ( reponse == 'N' || reponse == 'n') {
													ct=0;
												}
											} catch (StringIndexOutOfBoundsException e) {
												System.out.println("Saisie incorrecte!!!");
											}
										} while (ct==3);
										
									}
								}else {
									eleveRep='y';
								}
								ct++;
								if(reponse=='O' || reponse=='o') {break;}
							} while (eleveRep=='z');
							
							if (eleveSup.getIdEleve()!=-1) {
								Beneficier eleveBenef = new Beneficier();
								ServicesSup serviceSup = null;
								eleveBenef.setEleve(eleveSup);
								listeServices = iServiceServiceSupImpl.lire();
								System.out.println("\r______________________________________________________________");
								System.out.println("\rPRESENTATION DES INFORMATIONS DE L'ELEVE APRES SUPPRESSION");
								System.out.println("\r_______________________________________________________________");
								Iterator<ServicesSup> itService =  listeServices.iterator();
								while (itService.hasNext()) {
									serviceSup = (ServicesSup) itService.next();
									eleveBenef.setServiceSup(serviceSup);
									iServiceBeneficierImpl.supprimer(eleveBenef);
								}
								iserviceEleveImpl.supprimer(eleveSup);
								listeEleve = new ArrayList<>();
								listeEleve = iserviceEleveImpl.lire();
								listeEleve.stream().forEach(System.out::println);
							}
							break;

						case 4:
							System.out.println("*********** Retour au menu principal ***********");
							menuEleve = 99;
							break;
						default:
							System.out.println("Entrée incorrecte; Veuillez choisir parmi les actions possibles.");
							break;
						}

					} catch (InputMismatchException e) {
						System.out.println("Entrée incorrecte; Veuillez choisir parmi les actions possibles.");
						sc.nextLine();
					}
					if (menuEleve == 99) {
						reponse = 'O';
						break;
					}
				} while (menuEleve <= 0 || menuEleve > 4);
				break;

			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("Veuillez choisir sur la liste des actions.");
				break;
			}
			System.out.println("\r____________________________________________________");
			sc.nextLine();
			if (menuEleve != 99) {
				char scRep = 'b';
				do {
					System.out.println("Voullez vous faire une nouvelle opération???");
					System.out.println("O ou N");
					tache=0;
					try {
						reponse = sc.nextLine().charAt(0);
						if (reponse == 'O' || reponse == 'o' || reponse == 'N' || reponse == 'n') {
							scRep = reponse;
						}
					} catch (StringIndexOutOfBoundsException e) {
						System.out.println("Saisie incorrecte!!!");
						scRep = 'b';
					}
				} while (scRep == 'b');
			}

		} while (reponse == 'O' || reponse == 'o');
		sc.close();
		System.exit(0);

	}

}
