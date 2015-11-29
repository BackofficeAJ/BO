package sn.hubsocial.avisjournaux.backoffice.client.entities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class Commons {
//----------------------------------------TITRES----------------------------------------//
	public static final String ASKANE_SERVER = "http://askaneservertest.appspot.com";
	//public static final String ASKANE_SERVER = "http://localhost:8870";
	//public static final String AvisJournaux = "http://localhost:8000";
	//public static final String ASKANE_SERVER = "http://askaneserver.appspot.com";
	public static final String HTTP_REST_ENTITY = ASKANE_SERVER+"/rest/entity";
	public static final String HTTP_REST_APPLICATION = ASKANE_SERVER+"/rest/application";	
	public static final String HTTP_REST_ZONE = ASKANE_SERVER+"/rest/zone";
	public static final String HTTP_REST_CATEGORY = ASKANE_SERVER+"/rest/category";
	public static final String HTTP_REST_PRODUCT = ASKANE_SERVER + "/rest/product";
	public static final String HTTP_REST_USERAPPLICATION = ASKANE_SERVER + "/rest/userapplication";
	public static final String HTTP_REST_PAYS = ASKANE_SERVER + "/rest/pays";
	public static final String HTTP_REST_UTILISATEUR = ASKANE_SERVER + "/rest/user";
	public static final String HTTP_REST_OBJECT = ASKANE_SERVER + "/rest/object";
	public static final String HTTP_REST_REQUEST = ASKANE_SERVER + "/rest/request";
	public static final String HTTP_REST_CIRCLE = ASKANE_SERVER + "/rest/circle";
	public static final String HTTP_REST_NOTIFICATION = ASKANE_SERVER + "/rest/notification";
	public static final String HTTP_REST_ORGANISATION = ASKANE_SERVER + "/rest/organisation";
	public static final String HTTP_REST_KEYWORDS = ASKANE_SERVER + "/rest/keywords";
	public static final String SORTNAME = "sortname";
	public static final String SORTORDER = "sortorder";
	public static final String METHOD_GET = "GET";
	public static final String METHOD_PUT = "PUT";

	
	public static final String OBJ = "obj";

	public static final String URL = "Myurl";
	public static final String UTF8 = "UTF-8";
	public static final String ACTION = "action";
	public static final String LIST = "list";
	public static final String ADD = "add";	
	public static final String EDIT = "modif";
	public static final String DELETE = "delete";
	public static final String JSON_APPLI = "application/json";
	public static final String ID = "id";
	public static final String PRIX = "prix";
	public static final String SEUIL = "seuil";
	public static final String DATE = "date";
	public static final String LIEU = "lieu";
	public static final String ATTRIBUT = "attrib";
	public static final String VALEUR = "valeur";
	public static final String METHODE_POST = "POST";
	public static final String NOM = "name";
	public static final String CODE = "code";
	public static final String DESCRIPTION = "description";	
	
	public static String send(URL url, String method ){
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(method);
			connection.setReadTimeout(60000);
			Reader reader =new InputStreamReader(connection.getInputStream(), "UTF-8");
			StringWriter writer = new StringWriter();
			IOUtils.copy(reader, writer);
			
			return writer.toString();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	public static <T extends Entity> String send( T entity, URL url, String method ){

		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setReadTimeout(60000);
			connection.setRequestMethod(method);
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
			writer.write(entity.toString());
			writer.close();
			InputStream response = connection.getInputStream();
			Reader reader = new InputStreamReader(response, "UTF-8");
			BufferedReader  stream = new BufferedReader(reader);
			String s;
			StringBuffer condition = new StringBuffer();
			while ((s = stream.readLine()) != null) {
				condition.append(s);
				condition.append("\n");
			}
			return condition.toString();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	
}