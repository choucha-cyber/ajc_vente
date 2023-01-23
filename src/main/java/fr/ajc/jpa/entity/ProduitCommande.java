package fr.ajc.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProduitCommande") // La table en bdd
public class ProduitCommande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "produitCommande_id")
	Integer ProduitCommandeId;

	@Column(name = "id_produit")
	private Integer produitId;
	@Column(name = "id_commande")
	private Integer commandeId;
	
	Integer qte;

	public ProduitCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProduitCommande(int produitId, int commandeId, Integer qte) {
		super();
		this.produitId = produitId;
		this.commandeId = commandeId;
		this.qte = qte;
	}

	public ProduitCommande(Integer qte) {
		super();
		this.qte = qte;
	}

	public int getProduitId() {
		return produitId;
	}

	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}

	public int getCommandeId() {
		return commandeId;
	}

	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "ProduitCommande [produitId=" + produitId + ", commandeId=" + commandeId + ", qte=" + qte + "]";
	}

}
