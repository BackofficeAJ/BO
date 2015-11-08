package sn.hubsocial.avisjournaux.backoffice.client.entities;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Objet extends Entity{

	
	
	private static final long serialVersionUID = 11256781326L;
	private String name;
	private String description;
	private String lieu;
	private String image;
	private Date creationDate;
	private Date endDate;	
	private String codeConfirm;
	private String status;
	private String visible;
	private Integer type;
	private Boolean isPack;
	private Integer seuil;
	private Request myRequest;
	private Long organisationId;
	private Long authorId;
	private Long paysId;
	private String reference;
	private Organisation organisation;
	private Pays pays;
	private Utilisateur author;
	Long creatorId;
	private UserApplication creator;
	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getPaysId() {
		return paysId;
	}

	public void setPaysId(Long paysId) {
		this.paysId = paysId;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Utilisateur getAuthor() {
		return author;
	}

	public void setAuthor(Utilisateur author) {
		this.author = author;
	}

	private List<Product> products;	
	Long ZoneId;
	private Zone zone;
	private List<Comment> comments;
	private static Boolean withComment = false;
	private static Boolean withCreator = false;
	private static Boolean withRequest = false;
	public static Long withMyRequest = null;
	private List<Request> requests;
	private Boolean isPrivate;
	private List<Long> circlesId;
	private Integer nbComment;
	private Integer nbTong;
	private Integer sumTong;
	private Integer sumSeuil;
	
	public Objet() {
		super();
	}
	
	public String getCodeConfirm() {
		return codeConfirm;
	}

	public void setCodeConfirm(String codeConfirm) {
		this.codeConfirm = codeConfirm;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName(){
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
	
	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

		

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public void setCreator(UserApplication creator) {
		this.creator = creator;
	}

	public UserApplication getCreator() {
		return creator;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public Long getZoneId() {
		return ZoneId;
	}

	public void setZoneId(Long zoneId) {
		ZoneId = zoneId;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Zone getZone() {
		return zone;
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public static void setWithComment(Boolean withComment) {
		Objet.withComment = withComment;
	}

	public static Boolean getWithComment() {
		return withComment;
	}

	public static void setWithCreator(Boolean withCreator) {
		Objet.withCreator = withCreator;
	}

	public static Boolean getWithCreator() {
		return withCreator;
	}

	public void setCirclesId(List<Long> circlesId) {
		this.circlesId = circlesId;
	}

	public List<Long> getCirclesId() {
		return circlesId;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public static void setWithRequest(Boolean withRequest) {
		Objet.withRequest = withRequest;
	}

	public static Boolean getWithRequest() {
		return withRequest;
	}

	public void setNbTong(Integer nbTong) {
		this.nbTong = nbTong;
	}

	public Integer getNbTong() {
		return nbTong;
	}

	public void setSumTong(Integer sumTong) {
		this.sumTong = sumTong;
	}

	public Integer getSumTong() {
		return sumTong;
	}

	public void setNbComment(Integer nbComment) {
		this.nbComment = nbComment;
	}

	public Integer getNbComment() {
		return nbComment;
	}

	public Integer getSumSeuil() {
		return sumSeuil;
	}

	public void setIsPack(Boolean isPack) {
		this.isPack = isPack;
	}

	public Boolean getIsPack() {
		return isPack;
	}

	public void setSumSeuil(Integer sumSeuil) {
		this.sumSeuil = sumSeuil;
	}

	public void setSeuil(Integer seuil) {
		this.seuil = seuil;
	}

	public Integer getSeuil() {
		return seuil;
	}

	public void setMyRequest(Request myRequest) {
		this.myRequest = myRequest;
	}

	public Request getMyRequest() {
		return myRequest;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getVisible() {
		return visible;
	}
	
	private Product getProduct(List<Product> lPr, Long id){
		
		for (Product p:lPr){
			if (p.getId().equals(id))
				return p;
		}
		return null;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getReference() {
		return reference;
	}

	public Long getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(Long organisationId) {
		this.organisationId = organisationId;
	}
	
}
