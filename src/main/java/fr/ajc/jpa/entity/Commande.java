package fr.ajc.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Commande") // La table en bdd
@SequenceGenerator(name = "Commande_gen", sequenceName = "Commande_seq", initialValue = 1, allocationSize = 1) // Auto
//increment
public class Commande {
	
	@Id
	@GeneratedValue(generator="Commande_gen")
	Integer id;
	LocalDate dateCréation;
	
	//Commande * ------- 1 Client
	@ManyToOne //-->plusieurs commande pour 1 client
	@JoinColumn(name="client_id")
	private Client Client;
	
	//Commande * ------- * Produit	
	//un produit est fourni pour une commande, donc many produits peuvent etre fournit pour une commande
//	@ManyToMany(mappedBy="produits")
//	private List<Produit> produits;

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

	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCréation=" + dateCréation + ", Client=" + Client + "]";
	}


	

}
