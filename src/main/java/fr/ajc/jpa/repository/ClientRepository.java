package fr.ajc.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.ajc.jpa.entity.Client;

public class ClientRepository extends EntityRepository<Client>{

	public ClientRepository(EntityManagerFactory emf) {
		super(emf, Client.class);
	}
	
	
	public Boolean createWithUser(Client client) {
		EntityManager em = null;
		EntityTransaction tx = null;
		Boolean created = true;
		try {
			
			// Créer un EntityManager
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			// Requètes avec le EntityManager
			// Créer l'user
			em.persist(client.getUserClient());
			
			// Créer le formateur
			em.persist(client);
			
			
			tx.commit();			
		} catch(Exception e) {
			created = false;
			// Erreur bdd
			if(tx!=null && tx.isActive()) {
				tx.rollback();
			}	
			e.printStackTrace();
		} finally {
			if(em!=null) {
				em.close();
			}
		}
		
		return created;
	}
	
	
}
