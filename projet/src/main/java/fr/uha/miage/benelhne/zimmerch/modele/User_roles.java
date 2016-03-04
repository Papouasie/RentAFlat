package fr.uha.miage.benelhne.zimmerch.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "User_roles.findByIduser",
			query = "SELECT R FROM User_roles R WHERE R.iduser =?1")
public class User_roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String role;
	private String username;
	private long iduser;
	
	public User_roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_roles(String role, String username) {
		//super();
		this.role = role;
		this.username = username;
	}
	public User_roles(String roleu, String username2, Long iduser2) {
		super();
		this.role=roleu;
		this.username=username2;
		this.iduser=iduser2;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getIduser() {
		return iduser;
	}
	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

}
