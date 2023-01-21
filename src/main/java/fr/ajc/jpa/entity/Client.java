package fr.ajc.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Client") // La table en bdd
@SequenceGenerator(name = "Client_gen", sequenceName = "Client_seq", initialValue = 1, allocationSize = 1) // Auto
//increment
public class Client {
	@Id
	@GeneratedValue(generator="Client_gen")
	private Integer id;
	private String nom;
	private String prenom;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User userClient;
	
//	@ManyToMany(mappedBy="commandes")
//	private List<Commande> commandes;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(Integer id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	
	public Client(String nom, String prenom, User userClient) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.userClient = userClient;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public User getUserClient() {
		return userClient;
	}
	public void setUserClient(User userClient) {
		this.userClient = userClient;
	}
	

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom +", userClient="
				+ userClient + "]";
	}
	
	

}
