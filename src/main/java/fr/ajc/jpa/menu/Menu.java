package fr.ajc.jpa.menu;

import java.util.List;
import java.util.Scanner;

import fr.ajc.jpa.Main;
import fr.ajc.jpa.entity.Commande;

import fr.ajc.jpa.entity.Produit;
import fr.ajc.jpa.entity.User;



public class Menu {
	static Scanner sc = new Scanner(System.in);
	public static void start() {
		Integer choice;
		do {
			System.out.println("1 - S'inscrire\n2 - Se connecter\n3 - Quitter");
			choice = sc.nextInt();
			if (choice == 1) {
				register();
			} else if (choice == 2) {
				login();
				choice = 3; // Quitte
			}
		} while (choice != 3);
		System.out.println("Aurevoir.");
	}

	private static void login() {
		System.out.println("-- Connexion --");
		while (true) {
			System.out.println("Votre identifiant : ");
			String identifiant = sc.next();
			System.out.println("Votre mot de passe : ");
			String mdp = sc.next();
			List<User> matchs = Main.userRepo.findByUsernameAndPassword(identifiant, mdp);
			if (matchs.isEmpty()) {
				System.out.println("Identifiant ou mot de passe incorrect.\n1 - Réessayer\n2 - S'inscrire");
				Integer choice = sc.nextInt();
				if (choice == 2)
					register();
			} else {
				User u = matchs.get(0);
				System.out.println("Connexion réussie !!!!!!\nBienvenue " + u.getUsername());
				qteStockOk();
				break;
			}
		}

	}

	private static void register() {
		System.out.println("-- Inscription --");
		while (true) {
			System.out.println("Votre identifiant : ");
			String identifiant = sc.next();
			System.out.println("Votre mot de passe : ");
			String mdp = sc.next();
			if (Main.userRepo.findByUsername(identifiant).size() == 0) {
				Main.userRepo.create(new User(identifiant, mdp));
				break;
			} else {
				System.out.println("Le nom d'utilisateur " + identifiant + " existe déjà. Veuillez réessayer");
			}
		}
		System.out.println("Inscription réussie, revenez pour vous connecter !");
	}
	
	//si produit en stock, poursuite commande ok
	public static void qteStockOk() {
		//si qté == 0, alors pas affiché produit dans la liste
		List<Produit> produits =  Main.produitRepo.findAll();
		System.out.println("-- Liste de nos produits --");
		for(Produit produit:produits) {		
			System.out.println("Produit : " +produit.getLibelle()+ " prix : " + produit.getPrix());
		}
		//System.out.println(produits);
		//Main.produitRepo.findAll().getClass().getName(); 
		System.out.println("-- Choisissez un produit dans la liste --");
		String choixProduit = sc.next();
				for(Produit produit:produits) {
					if(produit.getQteStock()==0) {	
						System.out.println("Le produit" +choixProduit+"n'est plus en stock");
					}
					else {
						System.out.println("Tapez la quantité souhaité");
						int qte = sc.nextInt();
						System.out.println("quantité : " + qte+ "du Produit" +produit.getLibelle()+"ajouté à votre commande");
						//Integer id, Integer qte, Produit produit, Commande commande
						//Main.commandeProduitRepo.create(new CommandeProduit(qte, produit));
					}
					
					System.out.println("Continuez vos achats - 1");
					System.out.println("Validez votre commande - 2");
					int poursuiteOuValide = sc.nextInt();
					if(poursuiteOuValide == 2) {
						validateCommande();
					} else qteStockOk();
					
				}
	}
	
	//valider commande
	public static void validateCommande() {
		System.out.println("Votre commande a bien été enregistré");
		System.out.println("Vous allez être redigéré vers le paiement");
		System.out.println("Veuillez patienter...");
		Main.commandeRepo.create(new Commande());	
	}

}
