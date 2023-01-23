package fr.ajc.jpa.entity;

import java.time.LocalDate;

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
@Table(name = "Commande") // La table en bdd
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "commande_id")
	Integer id;
	LocalDate dateCréation;
	
	//Commande * ------- 1 Client
	@ManyToOne //-->plusieurs commande pour 1 client
	@JoinColumn(name="client_id")
	private Client Client;
	
	//ProduitCommande
	@OneToOne
	@JoinColumn(name="produitCommandeId")
	private ProduitCommande produitCommande;


	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(LocalDate dateCréation, Client client) {
		super();
		this.dateCréation = dateCréation;
		Client = client;
	}

	public Commande(Integer id, LocalDate dateCréation, Client client) {
		super();
		this.id = id;
		this.dateCréation = dateCréation;
		Client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateCréation() {
		return dateCréation;
	}

	public void setDateCréation(LocalDate dateCréation) {
		this.dateCréation = dateCréation;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public ProduitCommande getProduitCommande() {
		return produitCommande;
	}

	public void setProduitCommande(ProduitCommande produitCommande) {
		this.produitCommande = produitCommande;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCréation=" + dateCréation + ", Client=" + Client + "]";
	}


	

}
