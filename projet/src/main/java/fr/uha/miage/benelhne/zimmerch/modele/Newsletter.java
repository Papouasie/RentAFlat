package fr.uha.miage.benelhne.zimmerch.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Newsletter {
	@Id
	@GeneratedValue
	private Long id_n;
	private String email_n;
	
	public Long getId_n() {
		return id_n;
	}
	public void setId_n(Long id_n) {
		this.id_n = id_n;
	}
	public String getEmail_n() {
		return email_n;
	}
	public void setEmail_n(String email_n) {
		this.email_n = email_n;
	}
	
}
