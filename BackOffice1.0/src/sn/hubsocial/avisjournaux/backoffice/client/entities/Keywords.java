package sn.hubsocial.avisjournaux.backoffice.client.entities;
import java.util.Date;
import java.util.List;


public class Keywords extends Entity {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1454879862L;
	private Long objectId;
	private Date creationDate;
	private List<String> keywords;
	private Objet objet;

	public Keywords() {
		super();
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<String> getKeywords() {
		return this.keywords;
	}

	
	public static Boolean searchDoublon(List<Long> ids, Long id){
		for (Long l : ids){
			if(l.longValue() == id)
				return true;
		}
		return false;
	}

	
	
	

	
	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	public Objet getObjet() {
		return objet;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}


}
