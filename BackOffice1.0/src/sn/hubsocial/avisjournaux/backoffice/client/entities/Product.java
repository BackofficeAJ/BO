package sn.hubsocial.avisjournaux.backoffice.client.entities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Product extends Entity{

	/**
	 * @author atciss
	 */
	private static final long serialVersionUID = 11256781326L;
	private String name;
	private String description;
	private Double prix;
	private Double prixMarche;
	private Double prixAchat;
	private Double seuil;
	private int seuil_security;
	private int restant;
	private String unite;
	private String uniteAchat;
	private int rapportAchatVente;
	private String image;
	private int quantity;
	private int nbRequest;
	private int sumRequest;
	private Long categorieId;
	private Categorie categorie;
	
	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getSeuil() {
		return seuil;
	}

	public void setSeuil(Double seuil) {
		this.seuil = seuil;
	}
	
	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Product() {
		super();
	}
	
/*
 * Todo	Methode addProduct
 */
	
	public Long getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(Long categorieId) {
		this.categorieId = categorieId;
	}

	
	public int getNbRequest() {
		return nbRequest;
	}

	public void setNbRequest(int nbRequest) {
		this.nbRequest = nbRequest;
	}

	public int getSumRequest() {
		return sumRequest;
	}

	public void setSumRequest(int sumRequest) {
		this.sumRequest = sumRequest;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setPrixMarche(Double prixMarche) {
		this.prixMarche = prixMarche;
	}

	public Double getPrixMarche() {
		return prixMarche;
	}
	
	
	public int getSeuil_security() {
		return seuil_security;
	}

	public void setSeuil_security(int seuil_security) {
		this.seuil_security = seuil_security;
	}

	public int getRestant() {
		return restant;
	}

	public void setRestant(int restant) {
		this.restant = restant;
	}

	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getRapportAchatVente() {
		return rapportAchatVente;
	}

	public void setRapportAchatVente(int rapportAchatVente) {
		this.rapportAchatVente = rapportAchatVente;
	}

	public String getUniteAchat() {
		return uniteAchat;
	}

	public void setUniteAchat(String uniteAchat) {
		this.uniteAchat = uniteAchat;
	}
}
