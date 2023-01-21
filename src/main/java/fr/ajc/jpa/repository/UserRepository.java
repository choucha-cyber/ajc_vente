package fr.ajc.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.ajc.jpa.entity.User;

public class UserRepository extends EntityRepository<User>{

	// attribut EntityManager + le constructeur de la calsse avec cet att
	private EntityManagerFactory emf;

	public UserRepository(EntityManagerFactory emf) {

		super(emf, User.class);
	}

	// REQUETES SQL

//	// findAll-->avec req SQL
//	@SuppressWarnings("unchecked")
//	public List<User> findAllSQL() {
//		EntityManager em = null;
//		EntityTransaction tx = null;
//		List<User> users = new ArrayList<>();
//		try {
//
//			// Créer un EntityManager
//			em = emf.createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			// Requètes avec le EntityManager
//			Query query = em.createNativeQuery("select id,username,password from Utilisateur", User.class);
//
//			users = query.getResultList();
//
//			tx.commit();
//		} catch (Exception e) {
//			// Erreur bdd
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//		} finally {
//			if (em != null) {
//				em.close();
//			}
//		}
//
//		return users;
//	}

//	// findAll avec JPQL
//	public List<User> findAllJPQL() {
//		EntityManager em = null;
//		EntityTransaction tx = null;
//		List<User> users = new ArrayList<>();
//		try {
//
//			// Créer un EntityManager
//			em = emf.createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			// Requètes avec le EntityManager
//			TypedQuery<User> tq = em.createQuery("SELECT u FROM User u", User.class);
//
//			users = tq.getResultList();
//
//			tx.commit();
//		} catch (Exception e) {
//			// Erreur bdd
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//		} finally {
//			if (em != null) {
//				em.close();
//			}
//		}
//
//		return users;
//	}

	// JPQL
	public List<User> findByUsername(String username) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<User> users = new ArrayList<>();
		try {

			// Créer un EntityManager
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			// Requètes avec le EntityManager
			TypedQuery<User> tq = em.createQuery("SELECT u FROM User u WHERE u.username=:username", User.class);

			tq.setParameter("username", username);

			users = tq.getResultList();

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

		return users;
	}

	// finbByUserNameAndPassword
	public List<User> findByUsernameAndPassword(String username, String password) {
		List<User> users = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			// JPQL => Avec le nom des classes et des attributs JAVA !!!
			TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.username = :username and u.password = :password",
					User.class);

			q.setParameter("username", username);
			q.setParameter("password", password);

			users = q.getResultList();

			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return users;
	}

}
