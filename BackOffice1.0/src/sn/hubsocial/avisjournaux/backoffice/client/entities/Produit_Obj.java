package sn.hubsocial.avisjournaux.backoffice.client.entities;


public class Produit_Obj extends Entity{

	/**
	 * @author sambinfo_ad
	 */
	private static final long serialVersionUID = 11256781326L;
	private Long produitId;
	private Product produit;

	public Produit_Obj() {
		super();
	}


	
	public Long getProduitId() {
		return produitId;
	}

	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}


	public Product getProduit() {
		return produit;
	}

	public void setProduit(Product produit) {
		this.produit = produit;
	}
}
