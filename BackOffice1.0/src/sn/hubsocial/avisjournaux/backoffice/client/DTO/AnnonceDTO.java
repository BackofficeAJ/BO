package sn.hubsocial.avisjournaux.backoffice.client.DTO;

public class AnnonceDTO {

	
	private static final long serialVersionUID = 1L;

	 private static int nextId = 0;
	
	private int id;
	private String titre;
	private String structure;
	private String fichier;
	private String resume;
	private String typequot;	
	private String localite;

	public AnnonceDTO() {
		// TODO Auto-generated constructor stub
	}

	public AnnonceDTO( String fichier, String titre, String resume , String structure,  String typequot, String localite) {
		super();
		 nextId++;
	     this.id = nextId;
		this.titre = titre;
		this.structure = structure;
		this.fichier = fichier;
		this.resume = resume;
		this.typequot = typequot;
		this.localite = localite;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}
	
	public String getlocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}
	

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public String getTypequot() {
		return typequot;
	}

	public void setTypequot(String typequot) {
		this.typequot = typequot;
	}

	/**
	 * @return the image
	 */
	public String getFichier() {
		return fichier;
	}

	/**
	 * @param image the image to set
	 */
	public void setFichier(String fichier) {
		this.fichier = fichier;
	}


}
