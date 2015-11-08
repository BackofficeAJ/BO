package sn.hubsocial.avisjournaux.backoffice.client.entities;
/**
 * @since 
 */
public class Zone extends Entity{

	private static final long serialVersionUID = 15487897879978L;
	private String name;
	private String code;

	public Zone() {
		super();
	}
	public Zone(String name,String code) {
		super();
		this.name = name;
		this.code = code;

	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}