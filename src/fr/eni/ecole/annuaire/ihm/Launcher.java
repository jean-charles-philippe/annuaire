package fr.eni.ecole.annuaire.ihm;

import java.util.List;
import java.util.Scanner;

import fr.eni.ecole.annuaire.bll.bo.Utilisateur;
import fr.eni.ecole.annuaire.dal.UtilisateurDAO;

public class Launcher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer numApp = 1;
		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		System.out.println();
		menu();
		numApp = sc.nextInt();
		sc.nextLine();

		// Afficher le menu à chaque fois après avoir saisi de 1 à 3 ou 4 pour quitter
		while (numApp != 4) {

			switch (numApp) {
			case 1:
				// 1 Ajouter un utilisateur , saisir un nom, prenom, mail, mdp puis transfert à
				// la bdd
				Utilisateur utilisateur = saisieUtilisateur(sc);
				utilisateurDAO.insert(utilisateur);
				break;

			case 2:
				// 2 Supprimer un utilisateur par le mail et supprime en bdd
				String email = saisirEmail(sc);
				utilisateurDAO.delete(email);
				break;

			case 3:
				// 3 faire un affichade total de l'annuaire
				List<Utilisateur> listUtilisateur = findAll();
				afficherContacts(listUtilisateur);
				break;

			default:
				break;
			}

			System.out.println("\n       ************");
			menu();
			numApp = sc.nextInt();
			sc.nextLine();
		}
		sc.close();
		System.out.println("Au revoir!");

	}

	private static List<Utilisateur> findAll() {
		List<Utilisateur> listUtilisateur;
		System.out.println("\nAFFICHAGE GLOBAL DE L'ANNUAIRE:");
		listUtilisateur = UtilisateurDAO.vueAnnuaire();
		return listUtilisateur;
	}

	private static String saisirEmail(Scanner sc) {
		System.out.println("Veuillez saisir le mail de l'utilisateur à supprimer:");
		String email = sc.nextLine();
		return email;
	}

	private static Utilisateur saisieUtilisateur(Scanner sc) {
		System.out.println("\nAJOUT D'UN CONTACT:");
		System.out.println("Veuillez saisir un nom:");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir un prenom:");
		String prenom = sc.nextLine();
		System.out.println("Veuillez saisir un email:");
		String email = sc.nextLine();
		System.out.println("Veuillez saisir un password:");
		String password = sc.nextLine();
		Utilisateur utilisateur = new Utilisateur(nom, prenom, email, password);
		return utilisateur;
	}

	private static void afficherContacts(List<Utilisateur> listUtilisateur) {
		for (Utilisateur user : listUtilisateur) {
			System.out.println(user.toString());
		}
	}

	public static void menu() {
		System.out.println("Bienvenue dans mon annuaire:");
		System.out.println("1 - Ajouter un contact");
		System.out.println("2 - Supprimer un contact");
		System.out.println("3 - Afficher les contacts");
		System.out.println("4 - Quitter\n");
	}
}
