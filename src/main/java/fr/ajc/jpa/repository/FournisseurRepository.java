package fr.ajc.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.ajc.jpa.entity.Fournisseur;


public class FournisseurRepository extends EntityRepository<Fournisseur>{
	
	private EntityManagerFactory emf;

	public FournisseurRepository(EntityManagerFactory emf) {
		super(emf, Fournisseur.class);
		
	}
	
	public Boolean createWithUser(Fournisseur fournisseur) {
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
			em.persist(fournisseur.getUserFournisseur());
			
			// Créer le formateur
			em.persist(fournisseur);
			
			
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
	
	
	public Fournisseur findByIdAndFetchProducts(Integer id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		Fournisseur fournisseur = null;
		try {
			// Créer un EntityManager
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			// Requètes avec le EntityManager
			TypedQuery<Fournisseur> query = em.createQuery(
					"SELECT fourn FROM Fournisseur form LEFT JOIN FETCH fourn.modules WHERE fourn.id=:id", Fournisseur.class);
			query.setParameter("id", id);

			fournisseur = query.getSingleResult();

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

		return fournisseur;
	}


}
