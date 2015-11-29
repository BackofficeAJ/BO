package sn.hubsocial.avisjournaux.backoffice.client.DTO;

import gwt.material.design.client.custom.MaterialSuggestionOracle;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;





import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

import sn.hubsocial.avisjournaux.backoffice.client.JSO.UserApplicationJSO;
import sn.hubsocial.avisjournaux.backoffice.client.dataGrid.AvisFormDataGrid;
import sn.hubsocial.avisjournaux.backoffice.client.dataGrid.StructureDataGrid;
import sn.hubsocial.avisjournaux.backoffice.client.entities.UserApplication;
import sn.hubsocial.avisjournaux.backoffice.client.restlet.proxy.UserApplicationProxy;

public class StructureDTO  {
	

	 private static long nextId = 0;
	
	private long id;
	private String nom;
	private String numero;
	private String email;
	public static ArrayList<UserApplication> listUserApplication;
	

	public StructureDTO(UserApplicationJSO structure) {
		this.id = structure.getId();
		this.nom = structure.getNom();
		this.numero = structure.getTelephone();
		this.email = structure.getEmail();
		// TODO Auto-generated constructor stub
	}
	
	public StructureDTO(UserApplication structure) {
		this.id = structure.getId();
		this.nom = structure.getNom();
		this.numero = structure.getTelephone();
		this.email = structure.getEmail();
		// TODO Auto-generated constructor stub
	}
	public StructureDTO() {
		super();
	}

	public StructureDTO( String nom, String numero, String email) {
		super();
		 nextId++;
	     this.id = nextId;
		this.nom = nom;
		this.numero = numero;
		this.email = email;
		
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//	autocompletion structure dans avis
	public static void retrieveStructure (final AvisFormDataGrid avisFormDataGrid){
		
		UserApplicationProxy userApplicationProxy = GWT.create(UserApplicationProxy.class);
			
			
			// Retrieve the structure
		//objetProxy.find(avisDataGrid.getOffset()+"", avisDataGrid.getPage()+"",new MethodCallback <List<Objet>>()
			userApplicationProxy.find(new MethodCallback <List<UserApplication>>() {
			   

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
				public void onSuccess(Method method, List<UserApplication> response) {
					// TODO Auto-generated method stub
					avisFormDataGrid.getStructure().setItemValues(new ArrayList<String>());
					listUserApplication = new ArrayList<UserApplication>();
					MaterialSuggestionOracle suggestions = new MaterialSuggestionOracle();
					for (UserApplication obj : response){
				    	
				    	if (obj != null) {
				    		StructureDTO structureDTO = new StructureDTO(obj);
				    		if (structureDTO.getNom() != null) {
				    			suggestions.add(structureDTO.getNom());
					    		listUserApplication.add(obj);
								
							}
				    		
						}
				    	
				    	
					}
					
					  avisFormDataGrid.getStructure().setSuggestions(suggestions);
				      //structureDataGrid.getSortDataHandler().setList(structureDataGrid.getModelStructureProvider().getList());
					
				}
				
			});
		}
	
	
public static void retrieve (final StructureDataGrid structureDataGrid){
		
	UserApplicationProxy userApplicationProxy = GWT.create(UserApplicationProxy.class);
		
		
		// Retrieve the structure
	//objetProxy.find(avisDataGrid.getOffset()+"", avisDataGrid.getPage()+"",new MethodCallback <List<Objet>>()
		userApplicationProxy.find(structureDataGrid.getOffset()+"", structureDataGrid.getPage()+"",new MethodCallback <List<UserApplication>>() {
		   

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
			public void onSuccess(Method method, List<UserApplication> response) {
				// TODO Auto-generated method stub
				structureDataGrid.getModelStructureProvider().setList(new ArrayList<StructureDTO>());
			    
				for (UserApplication obj : response){
			    	StructureDTO structureDTO = new StructureDTO(obj);
			    	//Window.alert("nom"+structureDTO.getNom());
			    	structureDataGrid.getModelStructureProvider().getList().add(structureDTO);
			    }
			      
			      structureDataGrid.getSortDataHandler().setList(structureDataGrid.getModelStructureProvider().getList());
			      structureDataGrid.setNbreSelection(0);
			}
		});
	}

	public static void save (UserApplication structure, final StructureDataGrid structureDataGrid){
		
		UserApplicationProxy userApplicationProxy = GWT.create(UserApplicationProxy.class);
		
		
		// Retrieve the contact
		userApplicationProxy.saveOrUpdate(structure,new MethodCallback <UserApplication>() {
		   
	
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
			public void onSuccess(Method method, UserApplication response) {
				// TODO Auto-generated method stub				
				retrieve(structureDataGrid);
			}
		});
	}

//	suppression
public static void delete (StructureDTO structureDTO, final StructureDataGrid structureDataGrid){
		
		UserApplicationProxy userApplicationProxy = GWT.create(UserApplicationProxy.class);
		
		
		// Retrieve the contact
		userApplicationProxy.remove(Long.valueOf(structureDTO.getId()), new MethodCallback <Boolean>(){
		   

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
				retrieve(structureDataGrid);
			}
		});
	}
	
}
