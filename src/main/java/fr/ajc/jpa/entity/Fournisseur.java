package fr.ajc.jpa.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Fournisseur") // La table en bdd
public class Fournisseur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "fournisseur_id")
	private Integer id;
	private String nomSociete;
	
	@OneToOne
	@JoinColumn(name="userFournisseur")
	private User userFournisseur;
	
	@OneToMany(mappedBy="fournisseur")//un fournisseur -->>plusieurs produits
	private List<Produit> produits;
	
	
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(Integer id, String nomSociete) {
		super();
		this.id = id;
		this.nomSociete = nomSociete;
	}

	public Fournisseur(String nomSociete, User userFournisseur, List<Produit> produits) {
		super();
		this.nomSociete = nomSociete;
		this.userFournisseur = userFournisseur;
		this.produits = produits;
	}
	public Fournisseur(String nomSociete) {
		super();
		this.nomSociete = nomSociete;
	}
	
	public Fournisseur(String nomSociete, User userFournisseur) {
	super();
	this.nomSociete = nomSociete;
	this.userFournisseur = userFournisseur;
}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	public User getUserFournisseur() {
		return userFournisseur;
	}
	public void setUserFournisseur(User userFournisseur) {
		this.userFournisseur = userFournisseur;
	}
	
	
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
//	@Override
//	public String toString() {
//		return "Fournisseur [id=" + id + ", nomSociete=" + nomSociete + ", userFournisseur=" + userFournisseur
//				+ ", produits=" + produits + "]";
//	}
	
	
	
}
