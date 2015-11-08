package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class productRequest  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quantity;
	private int prixMarche;
	private int prix;
	private Long id; 
	private Product productsComplete;


	public productRequest(){
		super();
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}



	public Product getProductsComplete() {
		return productsComplete;
	}

	public void setProductsComplete(Product productsComplete) {
		this.productsComplete = productsComplete;
	}

	
	public int getPrixMarche() {
		return prixMarche;
	}

	public void setPrixMarche(int prixMarche) {
		this.prixMarche = prixMarche;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
}