package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Request extends Post {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6227113134209329268L;

	public static boolean withLivraison = false;  
	public static boolean withProducts = false;  
	private int quantity;
	private String codeConfirm;
	private String status;
	private Double price;
	private String userTelephone;
	private String userEmail;
	private Long idOrg;

	private Livraison livraison;
	private Organisation organisation;
	private List<productRequest> products;

	public Request() {
		super();
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		super.setName(name);
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		super.setDescription(description);
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return super.getPosition();
	}

	/**
	 * @return the numValue
	 */
	public int getNumValue() {
		return super.getNumValue();
	}

	/**
	 * @return the valuation
	 */
	public float getValuation() {
		return super.getValuation();
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return super.getDate();
	}

	public String getName(){
		return super.getName();
	}

	public String getDescription(){
		return super.getDescription();
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setCodeConfirm(String codeConfirm) {
		this.codeConfirm = codeConfirm;
	}

	public String getCodeConfirm() {
		return codeConfirm;
	}

	public Long getCreatorId(){
		return super.getCreatorId();
	}

	public void setCreatorId(Long creatorId) {
		super.setCreatorId(creatorId);
	}

	public void setObjectId(Long objectId) {
		super.setObjectId(objectId);
	}

	public Long getObjectId() {
		return super.getObjectId();
	}

	

	public void setProducts(List<productRequest> products) {
		this.products = products;
	}

	public List<productRequest> getProducts() {
		return products;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
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

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserTelephone() {
		return this.userTelephone;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	public Livraison getLivraison() {
		return livraison;
	}	

	public List<Long> getproductsId(){
		List<Long> ids = new ArrayList<Long>();
		for (productRequest proR : products){
			ids.add(proR.getId());
		}
		return ids;
	}
	


}
