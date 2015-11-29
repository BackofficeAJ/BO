package sn.hubsocial.avisjournaux.backoffice.client.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

import sn.hubsocial.avisjournaux.backoffice.client.JSO.ObjetJSO;
import sn.hubsocial.avisjournaux.backoffice.client.dataGrid.AvisDataGrid;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Objet;
import sn.hubsocial.avisjournaux.backoffice.client.restlet.proxy.ObjetProxy;

public class AvisDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	 private static long nextId = 0;
	
	private long id;
	private String nom;
	private StructureDTO structure;
	private long structureId;
	private String fichierPdf;
	private String resume;
	private QuotidienDTO quotidien;	
	private String image;
	
	public AvisDTO(ObjetJSO askaneObject){
		this.id=askaneObject.getId();
		this.nom=askaneObject.getName();
		this.resume=askaneObject.getDescription();
		this.image=askaneObject.getImage();
		if (askaneObject.getOrganisation() != null) {
			this.quotidien = new QuotidienDTO(askaneObject.getOrganisation());
		}
		if (askaneObject.getCreator() != null) {
			this.structure = new StructureDTO(askaneObject.getCreator());
		}
		
		
		
	};
	
	public AvisDTO(Objet objet){
		this.id=objet.getId();
		this.nom=objet.getName();
		this.resume=objet.getDescription();
		this.image=objet.getImage();
		if (objet.getOrganisation() != null) {
			this.quotidien = new QuotidienDTO(objet.getOrganisation());
		}
		if (objet.getCreator() != null) {
			this.structure = new StructureDTO(objet.getCreator());
		}
		
	}
	
	public Objet entityFromDTO(){
		
		Objet objet = new Objet();
		objet.setName(nom);
		objet.setDescription(resume);
		objet.setImage(image);
		
		objet.setCreatorId(structure.getId());
		return objet;
	}
	
	

	public AvisDTO() {
		// TODO Auto-generated constructor stub
	}

	public AvisDTO( String nom, String structure,String fichierPdf, String resume , String quotidien, String image) {
		super();
		 
		this.nom = nom;
		this.structure = new StructureDTO(structure, null, null);
		this.fichierPdf = fichierPdf;
		this.resume = resume;
		this.quotidien = new QuotidienDTO(quotidien, "", null);
		this.image = image;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String titre) {
		this.nom = titre;
	}

	
	
	public String getPdf() {
		return fichierPdf;
	}

	public void setPdf(String fichierPdf) {
		this.fichierPdf = fichierPdf;
	}
	

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public StructureDTO getStructure() {
		return structure;
	}

	public void setStructure(StructureDTO structure) {
		this.structure = structure;
	}

	public long getStructureId() {
		return structureId;
	}

	public void setStructureId(long structureId) {
		this.structureId = structureId;
	}

	public QuotidienDTO getQuotidien() {
		return quotidien;
	}

	public void setQuotidien(QuotidienDTO quotidien) {
		this.quotidien = quotidien;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/*public static List<AvisDTO> retreive(int page, int offset, String sortOrder){
		ClientResource cr = new ClientResource(Commons.HTTP_REST_OBJECT + "?sortname=creationDate&sortorder=desc&rp="+offset+"&page="+page);
		List<AvisDTO> avis = new ArrayList<AvisDTO>(); 
		try {
			String json = cr.get().getText();
			Window.alert(json);
			JSONValue jsonVal = JSONParser.parseStrict(json);
		    JSONArray jsonArray = jsonVal.isArray();
		    for (int i=0; i < jsonArray.size(); ++i) {
		        JSONObject item=jsonArray.get(i).isObject();
		        ObjetJSO obj = (ObjetJSO) item.getJavaScriptObject();
		        avis.add(new AvisDTO(obj));
		      
		      }
		   
			return avis;

		} catch (Exception e) {
			String string="";
			for (StackTraceElement element : e.getStackTrace()) {
			    string += element + "\n";
			}
			Window.alert(string);
		}
		return null;
		
	}*/

	
	public static void retrieve (final AvisDataGrid avisDataGrid){
		
		ObjetProxy objetProxy = GWT.create(ObjetProxy.class);
		
		
		// Retrieve the contact
		objetProxy.find(avisDataGrid.getOffset()+"", avisDataGrid.getPage()+"",new MethodCallback <List<Objet>>() {
		   

			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO Auto-generated method stub
				String errormessage = exception.getMessage() + "\n";
		    	for (StackTraceElement s : exception.getStackTrace()){
		    		errormessage += s.getClassName() + " " +s.getMethodName() + " "+ s.getLineNumber()+ "\n" ;
		    	}
		    	Window.alert(errormessage);
			}

			@Override
			public void onSuccess(Method method, List<Objet> response) {
				// TODO Auto-generated method stub
				avisDataGrid.getOrderDTOProvider().setList(new ArrayList<AvisDTO>());
			      for (Objet obj : response){
			    	  AvisDTO avisDTO = new AvisDTO(obj);
			    	  avisDataGrid.getOrderDTOProvider().getList().add(avisDTO);
			      }
			      
			      avisDataGrid.getSortDataHandler().setList(avisDataGrid.getOrderDTOProvider().getList());
			      avisDataGrid.setNbreSelection(0);
			}
		});
	}
	
	public static void save (Objet avis, final AvisDataGrid avisDataGrid){
		
		ObjetProxy objetProxy = GWT.create(ObjetProxy.class);
		
		
		// Retrieve the contact
		objetProxy.saveOrUpdate(avis,new MethodCallback <Objet>() {
		   

			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO Auto-generated method stub
				String errormessage = exception.getMessage() + "\n";
		    	for (StackTraceElement s : exception.getStackTrace()){
		    		errormessage += s.getClassName() + " " +s.getMethodName() + " "+ s.getLineNumber()+ "\n" ;
		    	}
		    	Window.alert(errormessage);
			}

			@Override
			public void onSuccess(Method method, Objet response) {
				// TODO Auto-generated method stub
				
				retrieve(avisDataGrid);
			}
		});
	}
	
	//	suppression
	public static void delete (AvisDTO avis, final AvisDataGrid avisDataGrid){
			
			ObjetProxy objetProxy = GWT.create(ObjetProxy.class);
			
			
			// Retrieve the contact
			objetProxy.remove(Long.valueOf(avis.getId()), new MethodCallback <Boolean>(){
			   
	
				@Override
				public void onFailure(Method method, Throwable exception) {
					// TODO Auto-generated method stub
					String errormessage = exception.getMessage() + "\n";
			    	for (StackTraceElement s : exception.getStackTrace()){
			    		errormessage += s.getClassName() + " " +s.getMethodName() + " "+ s.getLineNumber()+ "\n" ;
			    	}
			    	Window.alert(errormessage);
				}
	
				@Override
				public void onSuccess(Method method, Boolean response) {
					// TODO Auto-generated method stub				
					retrieve(avisDataGrid);
				}
			});
		}
	

}
