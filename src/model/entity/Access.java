package model.entity;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class Access {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private Long idRole;
	@Persistent private Long idUrl;
	@Persistent private boolean status;
	@Persistent private Date created;
	
	
	public Access(Long idRole, Long idUrl, Date created){
		this.idRole = idRole;
		this.idUrl = idUrl;
		this.status = true;
		this.created = created;
	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
	public Long getIdUrl() {
		return idUrl;
	}
	public void setIdUrl(Long idUrl) {
		this.idUrl = idUrl;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void updateStatus(boolean status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
}
