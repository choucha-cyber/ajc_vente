package fr.ajc.jpa.repository;

import javax.persistence.EntityManagerFactory;

import fr.ajc.jpa.entity.ProduitCommande;

public class ProduitCommandeRepository extends EntityRepository<ProduitCommande>{

	public ProduitCommandeRepository(EntityManagerFactory emf) {
		super(emf, ProduitCommande.class);
		// TODO Auto-generated constructor stub
	}
	

}
