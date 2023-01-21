package fr.ajc.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.ajc.jpa.entity.Client;
import fr.ajc.jpa.entity.Fournisseur;
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
		
		List<User> user = userRepo.findByUsername("Mimo");
		System.out.println(user);

		Menu.start();
		//User
		//String username, String pwd, Client userClient
		//User user1 = new User("username3", "password3");
//		userRepo.create(user1);
		//User user2 = new User("username4", "password4");
//		userRepo.create(user2);
		//je crée et persisit des clients
		//String nom, String prenom, User userClient
		
	//Client client = new Client("client3", "pwd3", userRepo.findById(3));
		//clientRepo.createWithUser(new Client("client7", "pwd7"));
//		client.setUserClient(user1);
//		Client client2 = new Client("Client2", "cli2");
//		clientRepo.create(client2);
//		client.setUserClient(user2);
		
		//je crée et persisit des fournisseurs
//		Fournisseur four = new Fournisseur("société1");
//		fournisseurRepo.create(four);
//		Fournisseur four2 = new Fournisseur("société2");
//		fournisseurRepo.create(four2);
		
		//je crée et persiste des produits
		//String libelle, float prix, Integer qteStock, Fournisseur fournisseurProduit
//		Produit produit = new Produit("livre", 10.50f, 47, four);
//		produitRepo.create(produit);
//		Produit produit2 = new Produit("sac", 30.50f, 127, four2);
//		produitRepo.create(produit2);
		
		
		

		System.out.println("Connexion ok");

	}

	public static void initRepos(EntityManagerFactory emf) {
		userRepo = new UserRepository(emf);
		fournisseurRepo = new FournisseurRepository(emf);
		clientRepo = new ClientRepository(emf);
		commandeRepo = new CommandeRepository(emf);
		produitRepo = new ProduitRepository(emf);
	}

}
