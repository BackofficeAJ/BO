package sn.hubsocial.avisjournaux.backoffice.client.entities;


public class UserApplication extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 114587L;
	private String nom;
	private String prenom;
	private String password;
	private String adresse;
	private String telephone;
	private String email;
	private String image;
	private Long applicationId;
	private int etoile;
	private String profil;
	private String status;
	private Long idOrg;
	private int code;
	
	public static Boolean withOrganisation = false; 
	private Organisation organisation;
	public UserApplication() {
		super();
		profil = "USER";
		status = "NOT_ACTIVATED";
	}
	public UserApplication(String nom, String prenom, String password, String adresse,String telephone,String email,String image,Long applicationId,int etoile,String status, Long idOrg, int code) {

		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.image = image;
		this.applicationId = applicationId;	
		this.etoile = etoile;
		this.status = status;
		this.idOrg=idOrg;
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public int getEtoile() {
		return etoile;
	}
	public void setEtoile(int etoile) {
		this.etoile = etoile;
	}	
	
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getProfil() {
		return profil;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	
	public void setIdOrg(Long idOrg) {
		this.idOrg = idOrg;
	}
	public Long getIdOrg() {
		return idOrg;
	}
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	public Organisation getOrganisation() {
		return organisation;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
