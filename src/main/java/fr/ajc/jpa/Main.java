package fr.ajc.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.ajc.jpa.entity.Produit;
import fr.ajc.jpa.entity.User;
import fr.ajc.jpa.menu.Menu;
import fr.ajc.jpa.repository.ClientRepository;
import fr.ajc.jpa.repository.CommandeRepository;
import fr.ajc.jpa.repository.FournisseurRepository;
import fr.ajc.jpa.repository.ProduitRepository;
import fr.ajc.jpa.repository.UserRepository;


public class Main {

	public static UserRepository userRepo;
	public static FournisseurRepository fournisseurRepo;
	public static ClientRepository clientRepo;
	public static CommandeRepository commandeRepo;
	public static ProduitRepository produitRepo;

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vente_jpa");
		/*
		 * Un client peut décider de valider une commande si elle ne l'est pas déjà et
		 * que les produits demandés sont en stock.
		 * 
		 * Une commande validée ne peut pas être modifiée. Si la quantité de produit
		 * demandé n'est pas en stock, un message d'erreur doit s'afficher à
		 * l'utilisateur et la commande ne doit pas se valider, la quantité en stock des
		 * autres produits ne doit pas être diminuée non plus.
		 */
		// Instanciation du repository
		initRepos(emf);
		
		//pour commande se connecter -->CONNEXION OK!
		//System.out.println(produitRepo.findAll());
		//String libelle, float prix, Integer qteStock, Fournisseur fournisseur
//	Produit produit = new Produit("tabouret", (float) 19.9, 59, fournisseurRepo.findById(2));
//	produitRepo.create(produit); //-->TEST OK
	//List<Produit> produits = produitRepo.findAll(); //-->TEST OK
	//System.out.println(produits);
		
		
		
//		System.out.println(userRepo.findById(1)); //--> TEST OK

//		Client client = new Client("nom1", "prenom1", userRepo.findById(1));
//		client.setUserClient(userRepo.findById(1));
		
//		clientRepo.create(client); --> TEST OK
		
//		List<User> matchs = userRepo.findByUsernameAndPassword("user1", "mdp1");
//		System.out.println(matchs); //-->TEST OK
		

		Menu.start();
		
		System.out.println("Connexion ok");

	}

	public static void initRepos(EntityManagerFactory emf) {
		userRepo = new UserRepository(emf);
		fournisseurRepo = new FournisseurRepository(emf);
		clientRepo = new ClientRepository(emf);
		commandeRepo = new CommandeRepository(emf);
		produitRepo = new ProduitRepository(emf);
	}
	
	public static void create() {
		// CREATE
		User user = new User("newUser", "newUsermdp");

		if (userRepo.create(user)) {
			System.out.println("Utilisateur crée !!");
		} else {
			System.out.println("Problème !!");
		}
	}
	
	
}
