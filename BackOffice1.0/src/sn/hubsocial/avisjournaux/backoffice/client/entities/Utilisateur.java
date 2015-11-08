package sn.hubsocial.avisjournaux.backoffice.client.entities;



public class Utilisateur extends Entity {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6206975313276998951L;
		
	private String prenom ;
	private String nom ;
	private String profil;
	private String email;
	private Pays pays;
	private Long paysId;
	public Utilisateur() {
		super();
	}
	
	

	public Utilisateur(String prenom, String nom, String profil, String email,
			Pays pays) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.profil = profil;
		this.email = email;
		this.pays = pays;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}



	public Long getPaysId() {
		return paysId;
	}



	public void setPaysId(Long paysId) {
		this.paysId = paysId;
	}



}
