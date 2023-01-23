package fr.ajc.jpa.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Client") // La table en bdd

public class Client{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Integer id;
	private String nom;
	private String prenom;
	
	@OneToOne
	@JoinColumn(name="userClient")
	private User userClient;
	
//	@OneToMany(mappedBy="client")
//	private List<Commande> commandes;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(User userClient) {
	super();
	this.userClient = userClient;
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
