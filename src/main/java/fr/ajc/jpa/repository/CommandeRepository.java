package fr.ajc.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.ajc.jpa.entity.Commande;


public class CommandeRepository extends EntityRepository<Commande>{
//Crud Simple, fetchByIdWithProduit)
	
	private EntityManagerFactory emf;

public CommandeRepository(EntityManagerFactory emf) {
	super(emf, Commande.class);
}

//fetch by ID with produits
public Commande findByIdAndFetchProducts(Integer id) {
	EntityManager em = null;
	EntityTransaction tx = null;
	Commande commande = null;
	try {
		// Créer un EntityManager
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();

		// Requètes avec le EntityManager
		TypedQuery<Commande> query = em.createQuery(
				"SELECT comm FROM Commande comm LEFT JOIN FETCH comm.produits WHERE comm.id=:id", Commande.class);
		query.setParameter("id", id);

		commande = query.getSingleResult();

		tx.commit();
	} catch (Exception e) {
		// Erreur bdd
		if (tx != null && tx.isActive()) {
			tx.rollback();
		}
	} finally {
		if (em != null) {
			em.close();
		}
	}

	return commande;
}

}
