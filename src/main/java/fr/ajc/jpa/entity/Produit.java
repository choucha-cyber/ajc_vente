package fr.ajc.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Produit") // La table en bdd
	public class Produit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "produit_id")
	private Integer id;
	private String libelle;
	private float prix;
	private Integer qteStock;
	
	//un produit est fourni par un fournisseur, donc many produits peuvent etre fournit par le meme Fournisseur
	@ManyToOne
	@JoinColumn(name="fournisseur_id")//La colonne dans la table {produit} qui fait la jointure vers l'autre table {fournisseur}
	private Fournisseur fournisseur;
	
	//ProduitCommande
	@OneToOne
	@JoinColumn(name="produitCommandeId")
	private ProduitCommande produitCommande;

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(Integer id, String libelle, float prix, Integer qteStock, Fournisseur fournisseur) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.fournisseur = fournisseur;
	}
	
	public Produit(String libelle, float prix, Integer qteStock, Fournisseur fournisseur) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.fournisseur = fournisseur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Integer getQteStock() {
		return qteStock;
	}

	public void setQteStock(Integer qteStock) {
		this.qteStock = qteStock;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public ProduitCommande getProduitCommande() {
		return produitCommande;
	}

	public void setProduitCommande(ProduitCommande produitCommande) {
		this.produitCommande = produitCommande;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", qteStock=" + qteStock
				+ ", fournisseur=" + fournisseur + "]";
	}
	
	

}
