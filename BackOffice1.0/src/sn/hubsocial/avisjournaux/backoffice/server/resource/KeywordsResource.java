package sn.hubsocial.avisjournaux.backoffice.server.resource;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.restlet.data.Form;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import sn.hubsocial.avisjournaux.backoffice.client.dataGrid.Commons;
import sn.hubsocial.avisjournaux.backoffice.client.entities.Objet;

public class KeywordsResource extends ServerResource implements EntityResourceInterface<Objet> {

public static Gson gson;
	
	static{
		GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			@Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                String date = json.getAsJsonPrimitive().getAsString();
                    return new Date(new Long(date));
            }
        });
        
      gson = builder.create();
	}
	@Override
	public Objet saveOrUpdate(String objet) {
		
		try{
			String json = Commons.send(new URL(Commons.HTTP_REST_OBJECT), "PUT", objet);
			
			//cr.get().getText();
			return (Objet) (gson.fromJson(json, Objet.class));
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Objet> find() {
		
		Form form = new Form() ;
		String str  = Commons.HTTP_REST_OBJECT+ "?withcreator=1&"+"sortname=creationDate&sortorder=desc&";
		if(getRequest() != null ){
			form = getRequest().getResourceRef().getQueryAsForm() ;
			str +=form.getQueryString();
			
		}
		
		
		try{
			String json = Commons.send(new URL(str), "GET");
			
			//cr.get().getText();
			return (List<Objet>) (gson.fromJson(json,  new TypeToken <List<Objet>>(){}.getType()));
		}catch (Exception e){
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Boolean remove() {
		String[] tab = getRequest().getResourceRef().getQuery().split("=");
		Set map = getRequest().getAttributes().keySet();
		String str = Commons.HTTP_REST_OBJECT+"/"+tab[1];
		//ClientResource cr = new ClientResource(str);
		try{
			Commons.send(new URL(str), "DELETE");
		}catch (Exception e){
			
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	

}
