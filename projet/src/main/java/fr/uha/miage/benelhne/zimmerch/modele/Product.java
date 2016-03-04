package fr.uha.miage.benelhne.zimmerch.modele;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//BitDecimal permet d'insérer des types de prix

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;

	private String productName;
	private String productDescription;
	private BigDecimal productPrice;
	
	public Product() {
		super();
	}
	
	//pour manipuler cet objet avec une bdd, je vais ajouter des annotations
	

	public long getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public BigDecimal getPrix() {
		return productPrice;
	}
	public void setPrix(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	
}