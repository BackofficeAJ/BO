package sn.hubsocial.avisjournaux.backoffice.client.entities;
public class ObjReq {
			private Long id;
			private Long pays;
			private String name;
			private Long organisation;
			public Long getId() {
				return id;
			}
			
			public ObjReq() {
				
				// TODO Auto-generated constructor stub
			}

			public void setId(Long id) {
				this.id = id;
			}
			public Long getPays() {
				return pays;
			}
			public void setPays(Long pays) {
				this.pays = pays;
			}
			
			public void setName(String name){
				this.name = name;
			}
			
			public String getName(){
				return this.name;
			}

			public Long getOrganisation() {
				return organisation;
			}

			public void setOrganisation(Long organisation) {
				this.organisation = organisation;
			}
		}