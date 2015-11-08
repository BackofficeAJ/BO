// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 09/03/2013 11:46:10
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Commons.java

package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.io.IOUtils;

public class Commons
{

    public Commons()
    {
    }

    public static String send(URL url, String method)
    {
        try
        {
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod(method);
            connection.setReadTimeout(60000);
            Reader reader = new InputStreamReader(connection.getInputStream(), "UTF-8");
            StringWriter writer = new StringWriter();
            IOUtils.copy(reader, writer);
            connection.disconnect();
            return writer.toString();
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        return null;
    }

    public static String send(URL url, String method, String content)
    {
        try
        {
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod(method);
            connection.setReadTimeout(60000);
            OutputStreamWriter Os = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            Os.write(content);
            Os.close();
            Reader reader = new InputStreamReader(connection.getInputStream(), "UTF-8");
            StringWriter writer = new StringWriter();
            IOUtils.copy(reader, writer);
            connection.disconnect();

            return writer.toString();
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        return null;
    }

    
    public static String generate(int length)
    {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890";
        String pass = "";
        for(int x = 0; x < length; x++)
        {
            int i = (int)Math.floor(Math.random() * 62D);
            pass = (new StringBuilder(String.valueOf(pass))).append(chars.charAt(i)).toString();
        }

        return pass;
    }

    public static String generermd5(String chaine)
    {
        byte defaultBytes[] = chaine.getBytes();
        try
        {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
            StringBuffer hexString = new StringBuffer();
            for(int i = 0; i < messageDigest.length; i++)
            {
                String hex = Integer.toHexString(0xff & messageDigest[i]);
                if(hex.length() == 1)
                    hexString.append("0");
                hexString.append(hex);
            }

            chaine = (new StringBuilder()).append(hexString).toString();
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception) { }
        return chaine;
    }

    public static String addTask(String urlLing, String method, String content)
    {
        try
        {
            URL url = new URL((new StringBuilder("/Task?action=email&ln=")).append(urlLing).toString());
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod(method);
            connection.setReadTimeout(60000);
            OutputStreamWriter Os = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            Os.write(content);
            Os.close();
            Reader reader = new InputStreamReader(connection.getInputStream(), "UTF-8");
            StringWriter writer = new StringWriter();
            IOUtils.copy(reader, writer);
            return writer.toString();
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        return null;
    }

    private static String autoEscape(String str){
    	
    	
    	return str.replace("'","\\'");
    }
   public static final String ASKANE_SERVER = "http://askaneserver.appspot.com";
  // public static final String ASKANE_SERVER = "http://askaneservertest.appspot.com";
   // public static final String ASKANE_SERVER = "http://localhost:8070";
    public static final String HTTP_REST_OBJECT = ASKANE_SERVER + "/rest/object";
    public static final String HTTP_REST_PRODUCT = ASKANE_SERVER + "/rest/product";
    public static final String HTTP_REST_TONG = ASKANE_SERVER + "/rest/tong";
    public static final String HTTP_REST_CATEGORY = ASKANE_SERVER + "/rest/category";
    public static final String HTTP_REST_APPLICATION = ASKANE_SERVER + "/rest/application";
    public static final String HTTP_REST_USERAPPLICATION = ASKANE_SERVER + "/rest/userapplication";
    public static final String HTTP_REST_ENTITY = ASKANE_SERVER + "/rest/entity";
    public static final String HTTP_REST_ZONE = ASKANE_SERVER + "/rest/zone";
    public static final String HTTP_REST_REQUEST = ASKANE_SERVER + "/rest/request";
    public static final String HTTP_REST_NEWS = ASKANE_SERVER + "/rest/newsletter";
    public static final String HTTP_REST_LIVRAISON = ASKANE_SERVER + "/rest/livraison";
    public static final String HTTP_REST_COMMENT = ASKANE_SERVER + "/rest/comment";
    public static final String HTTP_REST_MESSAGE = ASKANE_SERVER + "/rest/message";
    public static final String HTTP_REST_NOTIFICATION = ASKANE_SERVER + "/rest/notification";
    public static final String HTTP_REST_CIRCLE = ASKANE_SERVER + "/rest/circle";
    public static final String HTTP_REST_MEMBER = ASKANE_SERVER + "/rest/member";
    public static final String HTTP_REST_SEND_EMAIL = "http://askaneserver.appspot.com/rest/send_mail";
    public static final String HTTP_REST_OFFRE = ASKANE_SERVER + "/rest/offer";
    public static final String HTTP_REST_SEND_NEWS = ASKANE_SERVER + "/rest/newsletter";
    public static final String HTTP_CRON_UPDATE_PRODUCTS = ASKANE_SERVER + "/tong?action=updateproducts";
    public static final String HTTP_CRON_HIDE_OBJECT = ASKANE_SERVER + "/tong?action=sethidden";
    public static final String ON = "1";
    public static final String OFF = "0";
    public static final String YES = "oui";
    public static final String NO = "non";
    public static final String URL = "Myurl";
    public static final String IDENTIFIANT = "identifiant";
    public static final String PARTICIPANT = "nbParticip";
    public static final String WITHCIRCLE = "withcircle";
    public static final String CURRENT_USER = "currentUser";
    public static final String WITHOBJET = "withobjet";
    public static final String ACTIVATED = "ACTIVATED";
    public static final String NOT_ACTIVATED = "NOT_ACTIVATED";
    public static final String LOCKED = "LOCKED";
    public static final String INCOMPLETE = "INCOMPLETE";
    public static final String UTF8 = "UTF-8";
    public static final String ACTION = "action";
    public static final String LIST = "list";
    public static final String FIRT_TONG = "firstTong";
    public static final String RECIPIENT = "recipient";
    public static final String SUBJECT_CANT_CONNECT = "Votre mot de passe TongTong";
    public static final String MSBODY_CANT_CONNECT = "Vous avez indiqu&eacute; que vous avez oubli&eacute; votre mot de passe TongTong. <br />";
    public static final String REMIND_LOGIN = "Votre login :";
    public static final String REMIND_PASSWD = "<br />Votre nouveau mot de passe :";
    public static final String SUBJECT_WELCOME = "Vous venez d'&ecirc;tre inscrit &agrave; TongTong";
    public static final String MSBODY_WELCOME = "Pour confirmer votre inscription veuillez cliquer sur ce lien.";
    public static final String COMPTE_IS_ACTIVATE = "http://www.tong-tong.biz/welcome?profil_id=";
    public static final String SUBJECT_EDIT_PASSWD = "Modification de votre mot de passe TongTong";
    public static final String MSBODY_EDIT_PASSWD = "Vous venez de modifier votre mot de passe TongTong.";
    public static final String SUBJECT_TONG_CREATED = "Nouveau tong dans votre cercle";
    public static final String SUBJECT_TONG_PUBLISHED = "Tong publi&eacute; dans votre cercle";
    public static final String SUBJECT_TONG_PARTICIPATED = "Nouveau tong pour";
    public static final String SUBJECT_TONG_COMMENTED = "a &eacute;galement comment&eacute; le tong";
    public static final String SUBJECT_MEMBER_ADD = "Vous avez &eacute;t&eacute; ajout&eacute; au cercle";
    public static final String SUBJECT_MEMBER_INVITED = "Vous avez envoy&eacute; une invitation &agrave;";
    public static final String MSBODY_TONG_CREATED = "a cr&eacute;&eacute; un tong et l'a partag&eacute; avec vous.<br />";
    public static final String MSBODY_TONG_PUBLISHED = "a publi&eacute; un tong et l'a partag&eacute; avec vous.<br />";
    public static final String MSBODY_TONG_COMMENTED = "a &eacute;crit :";
    public static final String MSBODY_TONG_PARTICIPATED = "vient d'enregistrer sa participation au tong";
    public static final String SUBJECT_TONG_CLOSE = "Votre Tong a &eacute;t&eacute; cl&ocirc;tur&eacute;";
    public static final String MSBODY_MEMBER_ADD = "vous a ajout&eacute; &agrave; son cercle";
    public static final String DESC_MEMBER_ADD = "et vous invite ainsi &agrave; faire partir de son r&eacute;seau de co-acheteur dans";
    public static final String DESC_TONGTONG = "TongTong est un ...<br />";
    public static final String BECOME_TONGTONG = "Pour connaitre et profiter des avantages de TongTong";
    public static final String REGISTER = "inscrivez vous ici";
    public static final String MSBODY_MEMBER_INVITED = "<br />Votre invitation :<br />";
    public static final String DESC_TONG = "Le tong s'intitule:";
    public static final String DESC_COMMENT = "Votre commentaire est:";
    public static final String SUBJECT = "subject";
    public static final String MSGBODY = "msgbody";
    public static final String TONG_RECEAVED = "tongreceave";
    public static final String LIST_TONG_CREER = "listtongcreer";
    public static final String NOTIFICATION_RECEAVE = "notificationreceave";
    public static final String VIEW_ALL_NOTIFICATION = "viewallnotification";
    public static final String NOTIF_IS_READ = "setNotifisRead";
    public static final String COUNT_NOTIF_LU = "countnotifnotread";
    public static final String LIST_CIRCLE = "listcircle";
    public static final String LIST_CIRCLE_MEMBER = "listcirclemember";
    public static final String LIST_TONG_CIRCLE = "listtongcircle";
    public static final String EDIT_CIRCLE = "editcircle";
    public static final String EDIT_IMG_CIRCLE = "editimgcircle";
    public static final String REMOVE_CIRCLE = "removecircle";
    public static final String LIST_MEMBER = "listmembre";
    public static final String LIST_MEMBER_CREER = "listmembercreer";
    public static final String REMOVE_MEMBER = "removeMember";
    public static final String INVITED_MEMBER = "invitedmember";
    public static final String LIST_MESSAGE_CREER = "listmessagecreer";
    public static final String READ_MESSAGE_CREATE = "readMessagecreate";
    public static final String READ_MESSAGE_SEND = "readMessageSend";
    public static final String VIEW_ONE_MESSAGE = "viewoneMessage";
    public static final String MESSAGE_IS_READ = "setMessageisRead";
    public static final String POPULATE = "populate";
    public static final String ADD = "add";
    public static final String REQUEST_ID = "requestId";
    public static final String COMPLETE_STEPS = "completesteps";
    public static final String TONG_PARTICIPER = "tongparticiper";
    public static final String TONGISABORTED = "tongisaborted";
    public static final String TONGISPUBLISH = "tongispublish";
    public static final String TONGISCLOSE = "tongisclose";
    public static final String TONGISEXPIRED = "tongisexpired";
    public static final String CONFIRM = "confirm";
    public static final String IS_CONFIRMED = "CONFIRMED";
    public static final String IS_UNCONFIRMED = "UNCONFIRMED";
    public static final String IS_CLOSE = "CLOSED";
    public static final String IS_PUBLISHED = "PUBLISHED";
    public static final String ISNT_PUBLISHED = "NOT_PUBLISHED";
    public static final String IS_ABORTED = "ABORTED";
    public static final String ISNT_VISIBLE = "NO";
    public static final String IS_VISIBLE = "YES";
    public static final String CLOSE = "close";
    public static final String ABORT = "abort";
    public static final String ADD_PHOTO = "addphotoprofil";
    public static final String MODIFIER_PROFIL = "modifierprofil";
    public static final String MODIFIER_PASSWD = "modifiermotdepasse";
    public static final String CONNECT = "connect";
    public static final String GET_DISPLAYED_PROFILE = "getdisplayedprofile";
    public static final String CANT_CONNECT = "cantconnect";
    public static final String RESEND_MESSAGE = "resendmessage";
    public static final String REINITIALIZE = "reinitializeemail";
    public static final String GET_SESSION = "getsession";
    public static final String OFF_SESSION = "offsession";
    public static final String SEND_MESSAGE = "sendMessage";
    public static final String RESPONSE_MESSAGE = "responseMessage";
    public static final String COUNT_MESSAGE_LU = "countmessagenotread";
    public static final String PROFIL_ID = "profil_id";
    public static final String PROFILE = "profileid";
    public static final String PROFIL = "profil";
    public static final String MY_SESSION = "Usersession";
    public static final String CIRCLE = "circle";
    public static final String IS_CONNECTED = "isConnected";
    public static final String MY_PROFIL = "myProfile";
    public static final String MESSAGE_LU = "messagelu";
    public static final String NOTIF_LU = "notiflu";
    public static final String EDIT = "modif";
    public static final String DELETE = "delete";
    public static final String JSON_APPLI = "application/json";
    public static final String ID = "id";
    public static final String OBJECT_ID = "objectId";
    public static final String ID_TONG = "id_tong";
    public static final String TONG_ID = "tongId";
    public static final String ID_CATEG = "id_categ";
    public static final String CIRCLE_ID = "circleId";
    public static final String CIRCLES_ID = "circlesId";
    public static final String MEMBERS_ID = "membersId";
    public static final String MEMBER_ID = "memberId";
    public static final String SORTNAME = "sortname";
    public static final String SORTORDER = "sortorder";
    public static final String RP = "rp";
    public static final String PAGE = "page";
    public static final String NOM = "nom";
    public static final String CODE = "code";
    public static final String PRENOM = "prenom";
    public static final String LOGIN = "email";
    public static final String PASSWD = "password";
    public static final String MD5 = "MD5";
    public static final String NEW_PASSWD = "newpassword";
    public static final String PSEUDO = "pseudo";
    public static final String ADRESSE = "adresse";
    public static final String TELEPHONE = "telephone";
    public static final String INDICE_SN = "(+221)";
    public static final String EMAIL = "email";
    public static final String INVITATION = "invitation";
    public static final String INVITED_ID = "invitedId";
    public static final String ID_APPLICATION = "applicationId";
    public static final String ETOILE = "etoile";
    public static final int ET_VISITE = 1;
    public static final int ET_INSCRIT = 5;
    public static final int ET_TONG_PARTICIPE = 10;
    public static final int ET_TONG_CREE = 20;
    public static final String LIBELLE = "libelle";
    public static final String PRODUCTS = "products";
    public static final String UNITE = "unite";
    public static final String PRIX = "prix";
    public static final String SEUIL = "seuil";
    public static final String DATE = "date";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String ZONE_ID = "zone_id";
    public static final String LIEU = "lieu";
    public static final String DATEEND = "endDate";
    public static final String ATTRIBUT = "attrib";
    public static final String VALEUR = "valeur";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_DELETE = "DELETE";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String TYPE = "type";
    public static final String POSITION = "position";
    public static final String STATUS = "status";
    public static final String VISIBLE = "visible";
    public static final String NUMVALUE = "numValue";
    public static final String VALUATION = "valuation";
    public static final String ID_User_APPLI = "userApplicationId";
    public static final String USER = "id_user";
    public static final String USER_SESSION = "user";
    public static final String WELCOME = "USERWELCOME";
    public static final String BIENVENUE = "Bienvenue";
    public static final String TONGTONG = "TongTong";
    public static final String CREATED = "TONGCREATED";
    public static final String PUBLISH = "TONGPUBLISH";
    public static final String PARTICIPATED = "TONGPARTICIPATED";
    public static final String COMMENTED = "TONGCOMMENTED";
    public static final String SEUILATTEINT = "SEUILTONGATTEINT";
    public static final String SEUIL_TONG = "Le seuil du tong ";
    public static final String ATTEINT = " est atteint";
    public static final String ABORTED = "TONGABORTED";
    public static final String CREATIONTONG = "La cr&eacute;ation du tong ";
    public static final String ESTANNULER = " &agrave &eacute;t&eacute; annuler";
    public static final String EXPIRED = "TONGEXPIRED";
    public static final String LETONG = "Le tong ";
    public static final String AEXPIRER = " &agrave expirer";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String MODERATEUR = "Le moderateur du hubsocial.";
    public static final String NEW_MEMBER = "vous &ecirc;tes un nouveau membre.";
    public static final String NEW_MEMBER_PARAMETER = "Pour parametrer votre compte hubsocial cliquez sur le lien...";
    public static final String IPARTICIPATED = "Je participe &agrave; mon tong";
    public static final String PARTICIPER = "participe au tong";
    public static final String NEW_PARTICIPANT = "participation";
    public static final String ISPACK = "isPack";
    public static final String CATEGORY = "category";
    public static final String PRODUCTS_CATEGORY_ID = "products.categorieId";
    public static final String ISSEARCHING = "issearching";
    public static final String CATEGORIE = "categorie";
    public static final String ID_CATEGORIE = "categorieId";
    public static final String IMG_ID = "image";
    public static final String ID_GENERER = "id_generer";
    public static final String PASS = "pass";
    public static final String CREATOR = "creatorId";
    public static final int NBR = 6;
    public static final String SAME_EMAIL = "same-email";
    public static final String WRONG_NUMBER = "wrong-number";
    public static final String WRONG_CAPTCHA = "wrong-captcha";
    public static final String SAISIR_SVP = "Saisir le mot SVP";
    public static final String ID_USERAPPLICATION = "userApplicationId";
    public static final String QUANTITY = "quantity";
    public static final String ANY = "any";
    public static final String EMAIL_SECOUR = "email-secour";
    public static final String FOUND_EMAIL = "FOUNDEMAIL";
    public static final String MESSAGE_NEW_PASSWD = "Votre mot de passe a &eacute;t&eacute; renouvell&eacute;!";
    public static final String MESSAGE_FOUND_PASSWD = "Votre demande d'obtention de nouveau mot de passe a r&eacute;ussi les informations d'acc&egrave;s au compte ont &eacute;t&eacute; envoy&eacute; &agrave; ";
    public static final String OBJECT = "objet";
    public static final String WITHCREATOR = "withcreator";
    public static final String CLE_PRIVEE = "6LdAGMwSAAAAAP7QPV1yz2hh2c3B6s9ES44M0XhW";
    public static final String CHALLENG = "recaptcha_challenge_field";
    public static final String RESPONSE = "recaptcha_response_field";
    public static final String IS_PRIVATE = "isprivate";
    public static final String APP = "app";
}
