package sn.hubsocial.avisjournaux.backoffice.client.DTO;

import gwt.material.design.client.custom.MaterialSuggestionOracle;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

import sn.hubsocial.avisjournaux.backoffice.client.JSO.OrganisationJSO;
import sn.hubsocial.avisjournaux.backoffice.client.dataGrid.AvisFormDataGrid;
import sn.hubsocial.avisjournaux.backoffice.client.dataGrid.QuotidienDataGrid;
import sn.hubsocial.avisjournaux.backoffice.client.dataGrid.QuotidienFormDataGrid;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Organisation;
import sn.hubsocial.avisjournaux.backoffice.client.restlet.proxy.OrganisationProxy;

public class QuotidienDTO {
	
	 private static long nextId = 0;
	private Long id;	
	private String name;
	private String email;
	private PaysDTO pays;
	public static ArrayList<Organisation> listOrganistionPays;
	public static ArrayList<Organisation> listOrganistion;
	
	
	
	public QuotidienDTO(OrganisationJSO org) {
		this.name = org.getName();
		this.email = org.getEmail();
		if (org.getPays() != null) {
			this.pays = new PaysDTO(org.getPays());
		}
		
	}
	
	public QuotidienDTO(Organisation org) {
		this.id = org.getId();
		this.name = org.getName();
		this.email = org.getEmail();
		if (org.getPays() != null) {
			this.pays = new PaysDTO(org.getPays());
		}
		
	}
	public QuotidienDTO() {
		super();
	}
	public QuotidienDTO(String name, String email, PaysDTO pays) {
		super();
		 nextId++;
	     this.id = nextId;
		this.name = name;
		this.email = email;
		this.pays = pays;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PaysDTO getPays() {
		return pays;
	}
	public void setPays(PaysDTO pays) {
		this.pays = pays;
	}

	
//	autocompletion Quotidien dans avis
	public static void retrieveQuotidien (final AvisFormDataGrid avisFormDataGrid){
		
		OrganisationProxy organisationProxy = GWT.create(OrganisationProxy.class);
			
			
			// Retrieve the structure
		//objetProxy.find(avisDataGrid.getOffset()+"", avisDataGrid.getPage()+"",new MethodCallback <List<Objet>>()
			organisationProxy.find(new MethodCallback <List<Organisation>>() {
			   

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
				public void onSuccess(Method method, List<Organisation> response) {
					// TODO Auto-generated method stub
					avisFormDataGrid.getStructure().setItemValues(new ArrayList<String>());
					listOrganistion = new ArrayList<Organisation>();
					MaterialSuggestionOracle suggestions = new MaterialSuggestionOracle();
					for (Organisation obj : response){
				    	
				    	if (obj != null) {
				    		QuotidienDTO quotidienDTO = new QuotidienDTO(obj);
				    		if (quotidienDTO.getName() != null) {
				    			suggestions.add(quotidienDTO.getName());
					    		listOrganistion.add(obj);								
							}				    		
						}				    	
					}
					
					  avisFormDataGrid.getTypeQuot().setSuggestions(suggestions);
				   }
				
			});
		}
	
	
//	autocompletion Pays dans quotidien
	public static void retrievePays (final QuotidienFormDataGrid quotidienFormDataGrid){
		
		OrganisationProxy organisationProxy = GWT.create(OrganisationProxy.class);
			
			
			// Retrieve the structure
		//objetProxy.find(avisDataGrid.getOffset()+"", avisDataGrid.getPage()+"",new MethodCallback <List<Objet>>()
			organisationProxy.find(new MethodCallback <List<Organisation>>() {
			   

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
				public void onSuccess(Method method, List<Organisation> response) {
					// TODO Auto-generated method stub
					quotidienFormDataGrid.getPays().setItemValues(new ArrayList<String>());
					listOrganistionPays = new ArrayList<Organisation>();
					MaterialSuggestionOracle suggestions = new MaterialSuggestionOracle();
					for (Organisation obj : response){				    	
				    	if (obj != null) {
				    		QuotidienDTO quotidienDto = new QuotidienDTO(obj);
				    		if (quotidienDto.getPays() != null) {
				    			if (quotidienDto.getPays().getLibelle() != null) {
				    				suggestions.add(quotidienDto.getPays().getLibelle());
						    		listOrganistionPays.add(obj);
								}							
							}
				    		
						}
				    	
				    	
					}
					
					  quotidienFormDataGrid.getPays().setSuggestions(suggestions);
				      //structureDataGrid.getSortDataHandler().setList(structureDataGrid.getModelStructureProvider().getList());
					
				}
				
			});
		}
	
	public static void retrieve (final QuotidienDataGrid quotidienDataGrid){
		
		OrganisationProxy organisationProxy = GWT.create(OrganisationProxy.class);
			
			
			// Retrieve the structure
		//objetProxy.find(avisDataGrid.getOffset()+"", avisDataGrid.getPage()+"",new MethodCallback <List<Objet>>()
		organisationProxy.find(quotidienDataGrid.getOffset()+"", quotidienDataGrid.getPage()+"",new MethodCallback <List<Organisation>>() {
			   

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
				public void onSuccess(Method method, List<Organisation> response) {
					// TODO Auto-generated method stub
					quotidienDataGrid.getModelQuotienProvider().setList(new ArrayList<QuotidienDTO>());
				    
					for (Organisation obj : response){
						QuotidienDTO quotidienDto = new QuotidienDTO(obj);
				    	//Window.alert("nom"+structureDTO.getNom());
				    	quotidienDataGrid.getModelQuotienProvider().getList().add(quotidienDto);
				    }
				      
				      quotidienDataGrid.getSortDataHandler().setList(quotidienDataGrid.getModelQuotienProvider().getList());
				      quotidienDataGrid.setNbreSelection(0);
					}
			});
		}

		public static void save (Organisation organisation, final QuotidienDataGrid quotidienDataGrid){
				
				OrganisationProxy organisationProxy = GWT.create(OrganisationProxy.class);
				
				
				// Retrieve the contact
				organisationProxy.saveOrUpdate(organisation,new MethodCallback <Organisation>() {
				   
			
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
					public void onSuccess(Method method, Organisation response) {
						// TODO Auto-generated method stub				
						retrieve(quotidienDataGrid);
					}
				});
			}
		
//		suppression
		public static void delete (QuotidienDTO quotidienDto, final QuotidienDataGrid quotidienDataGrid){
				
				OrganisationProxy organisationProxy = GWT.create(OrganisationProxy.class);
				
				
				// Retrieve the contact
				organisationProxy.remove(Long.valueOf(quotidienDto.getId()), new MethodCallback <Boolean>(){
				   

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
						retrieve(quotidienDataGrid);
					}
				});
			}
			
}
