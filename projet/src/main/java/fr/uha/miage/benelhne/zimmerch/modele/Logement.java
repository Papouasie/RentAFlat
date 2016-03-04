package fr.uha.miage.benelhne.zimmerch.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Logement.findByLEnabled",
				query = "SELECT L FROM Logement L WHERE L.l_enabled =?1"),
	@NamedQuery(name = "Logement.findByLogUser",
				query = "SELECT L FROM Logement L WHERE L.l_username =?1")
	/*@NamedQuery(name = "Logement.findByCriterias",
				query = "SELECT L FROM Logement L WHERE"
						+ "L.l_region LIKE ?1 "
						+ "AND L.l_ville LIKE ?2 "
						+ "AND L.l_type LIKE ?3 "
						+ "AND L.l_pieces LIKE ?4 "
						+ "AND L.l_surface LIKE ?5 "
						+ "AND L.l_price LIKE ?6 ")*/
})
public class Logement {
	@Id
	@GeneratedValue
	private Long l_id;
	private String l_title;
	private String l_img;
	
	private String l_ville;
	private String l_pays;
	private String l_adresse;
	private String l_CP;
	private String l_region;
	
	private String l_type;
	
	private String l_etat;
	private String l_reference;
	private String l_price;
	private String l_charges;
	private String l_quarter;
	private String l_description;
	private String l_surface;
	private String l_parution;
	private String l_pieces;
	private String l_ascence;
	private String l_terrasse;
	private String l_mandat;
	private String l_wc;
	private String l_sdb;
	private String l_chauffage;
	private String l_build;
	private String l_nameL;
	private String l_emailL;
	private String l_surnameL;
	private String l_numberL;
	private int l_enabled;
	
	private String l_username;
	
	public Logement(){
		super();
	}
	
	public Long getL_id() {
		return l_id;
	}
	public void setL_id(Long l_id) {
		this.l_id = l_id;
	}

	public String getL_etat() {
		return l_etat;
	}

	public void setL_etat(String l_etat) {
		this.l_etat = l_etat;
	}

	public String getL_title() {
		return l_title;
	}
	
	public void setL_title(String l_title) {
		this.l_title = l_title;
	}

	public String getL_type() {
		return l_type;
	}

	public void setL_type(String l_type) {
		this.l_type = l_type;
	}

	public String getL_ville() {
		return l_ville;
	}

	public void setL_ville(String l_ville) {
		this.l_ville = l_ville;
	}

	public String getL_pays() {
		return l_pays;
	}

	public void setL_pays(String l_pays) {
		this.l_pays = l_pays;
	}

	public String getL_adresse() {
		return l_adresse;
	}

	public void setL_adresse(String l_adresse) {
		this.l_adresse = l_adresse;
	}

	public String getL_CP() {
		return l_CP;
	}

	public void setL_CP(String l_CP) {
		this.l_CP = l_CP;
	}


	public String getL_reference() {
		return l_reference;
	}
	public void setL_reference(String l_reference) {
		this.l_reference = l_reference;
	}
	public String getL_price() {
		return l_price;
	}
	public void setL_price(String l_price) {
		this.l_price = l_price;
	}
	
	public String getL_charges() {
		return l_charges;
	}

	public void setL_charges(String l_charges) {
		this.l_charges = l_charges;
	}

	public String getL_quarter() {
		return l_quarter;
	}
	public void setL_quarter(String l_quarter) {
		this.l_quarter = l_quarter;
	}
	public String getL_description() {
		return l_description;
	}
	public void setL_description(String l_description) {
		this.l_description = l_description;
	}
	public String getL_surface() {
		return l_surface;
	}
	public void setL_surface(String l_surface) {
		this.l_surface = l_surface;
	}
	public String getL_parution() {
		return l_parution;
	}
	public void setL_parution(String l_parution) {
		this.l_parution = l_parution;
	}
	public String getL_pieces() {
		return l_pieces;
	}
	public void setL_pieces(String l_pieces) {
		this.l_pieces = l_pieces;
	}
	public String getL_ascence() {
		return l_ascence;
	}
	public void setL_ascence(String l_ascence) {
		this.l_ascence = l_ascence;
	}
	public String getL_terrasse() {
		return l_terrasse;
	}
	public void setL_terrasse(String l_terrasse) {
		this.l_terrasse = l_terrasse;
	}
	public String getL_mandat() {
		return l_mandat;
	}
	public void setL_mandat(String l_mandat) {
		this.l_mandat = l_mandat;
	}
	public String getL_wc() {
		return l_wc;
	}
	public void setL_wc(String l_wc) {
		this.l_wc = l_wc;
	}
	public String getL_sdb() {
		return l_sdb;
	}
	public void setL_sdb(String l_sdb) {
		this.l_sdb = l_sdb;
	}
	public String getL_chauffage() {
		return l_chauffage;
	}
	public void setL_chauffage(String l_chauffage) {
		this.l_chauffage = l_chauffage;
	}
	public String getL_build() {
		return l_build;
	}
	public void setL_build(String l_build) {
		this.l_build = l_build;
	}
	public String getL_nameL() {
		return l_nameL;
	}
	public void setL_nameL(String l_nameL) {
		this.l_nameL = l_nameL;
	}
	public String getL_emailL() {
		return l_emailL;
	}
	public void setL_emailL(String l_emailL) {
		this.l_emailL = l_emailL;
	}
	public String getL_surnameL() {
		return l_surnameL;
	}
	public void setL_surnameL(String l_surnameL) {
		this.l_surnameL = l_surnameL;
	}
	public String getL_numberL() {
		return l_numberL;
	}
	public void setL_numberL(String l_numberL) {
		this.l_numberL = l_numberL;
	}

	public int getL_enabled() {
		return l_enabled;
	}

	public void setL_enabled(int l_enabled) {
		this.l_enabled = l_enabled;
	}

	public String getL_img() {
		return l_img;
	}

	public void setL_img(String l_img) {
		this.l_img = l_img;
	}

	public String getL_region() {
		return l_region;
	}

	public void setL_region(String l_region) {
		this.l_region = l_region;
	}

	public String getL_username() {
		return l_username;
	}

	public void setL_username(String l_username) {
		this.l_username = l_username;
	}

}
