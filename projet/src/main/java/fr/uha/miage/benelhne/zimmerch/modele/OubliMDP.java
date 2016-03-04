package fr.uha.miage.benelhne.zimmerch.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NamedQuery(name = "OubliMDP.findByUsernameHashcde",
			query = "select O from OubliMDP O where O.username = ?1 and O.hashcde = ?2")
public class OubliMDP {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	private String hashcde;
	
	public OubliMDP(String addr_u, String btn) {
		this.username = addr_u;
		this.hashcde = btn;
	}
	
	public OubliMDP() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHashcde() {
		return hashcde;
	}
	public void setHashcde(String hashcde) {
		this.hashcde=hashcde;
	}
	
}
