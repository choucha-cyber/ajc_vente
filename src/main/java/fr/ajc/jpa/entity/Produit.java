package fr.ajc.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Produit") // La table en bdd
@SequenceGenerator(name = "Produit_gen", sequenceName = "Produit_seq", initialValue = 1, allocationSize = 1) // Auto
//increment
	public class Produit {
	
	@Id
	@GeneratedValue(generator="Produit_gen")
	private Integer id;
	private String libelle;
	private float prix;
	private Integer qteStock;
	
	//un produit est fourni par un fournisseur, donc many produits peuvent etre fournit par le meme Fournisseur
	@ManyToOne
	@JoinColumn(name="fournisseur_id")//La colonne dans la table {module} qui fait la jointure vers l'autre table {formateur}
	private Fournisseur fournisseurProduit;
	
//	@ManyToMany(mappedBy="commandes")
//	private List<Commande> commandes;
	@ManyToMany
	@JoinTable(
			name="produit_commande",
			joinColumns=@JoinColumn(name="produit_id"),
			inverseJoinColumns=@JoinColumn(name="commande_id")
			)
	private List<Commande> commandes;

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(Integer id, String libelle, float prix, Integer qteStock, Fournisseur fournisseurProduit) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.fournisseurProduit = fournisseurProduit;
	}

	public Produit(String libelle, float prix, Integer qteStock, Fournisseur fournisseurProduit) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.fournisseurProduit = fournisseurProduit;
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

	public Fournisseur getFournisseurProduit() {
		return fournisseurProduit;
	}

	public void setFournisseurProduit(Fournisseur fournisseurProduit) {
		this.fournisseurProduit = fournisseurProduit;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", qteStock=" + qteStock
				+ ", fournisseurProduit=" + fournisseurProduit + "]";
	}
	
	

}
