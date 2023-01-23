package fr.ajc.jpa.repository;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.ajc.jpa.entity.Produit;

public class ProduitRepository extends EntityRepository<Produit>{
	

	public ProduitRepository(EntityManagerFactory emf) {
		super(emf, Produit.class);
	}
	
	//findByProductName()
	public List<Produit> findByProductName(String libelle) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Produit> produits = new ArrayList<>();
		try {

			// Créer un EntityManager
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			// Requètes avec le EntityManager
			TypedQuery<Produit> tq = em.createQuery("SELECT p FROM Produit p WHERE p.libelle=:libelle", Produit.class);

			tq.setParameter("libelle", libelle);

			produits = tq.getResultList();

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

		return produits;
	}
	

	
}
