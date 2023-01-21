package fr.ajc.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity // Doit être gérée en BDD (=> il doit y avoir une table correspondante)
@Table(name = "User") // La table en bdd
@SequenceGenerator(name = "User_gen", sequenceName = "User_seq", initialValue = 1, allocationSize = 1) // Auto
// increment
public class User {

	@Id // Clé primaire
	@GeneratedValue(generator = "User_gen") // Auto increment
	private Integer id;
	private String username;//-->meme nom que la colonne donc pas d'annotation

	@Column(name = "password") // La colonne en bdd
	private String password;
	
	@OneToOne(mappedBy="userClient")
	private Client userClient;

	@OneToOne(mappedBy="userFournisseur")
	private Fournisseur userFournisseur;

	public User() {
		super();
	}

	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, Fournisseur userFournisseur) {
		super();
		this.username = username;
		this.password = password;
		this.userFournisseur = userFournisseur;
	}

	public User(String username, String password, Client userClient) {
		super();
		this.username = username;
		this.password = password;
		this.userClient = userClient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Client getUserClient() {
		return userClient;
	}

	public void setUserClient(Client userClient) {
		this.userClient = userClient;
	}

	public Fournisseur getUserFournisseur() {
		return userFournisseur;
	}

	public void setUserFournisseur(Fournisseur userFournisseur) {
		this.userFournisseur = userFournisseur;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}