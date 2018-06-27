package model.entity;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String name;
	@Persistent private String surname;
	@Persistent private String email;
	@Persistent private Date birth;
	@Persistent private String gender;
	@Persistent private Date created;
	@Persistent private boolean status;
	@Persistent private Long idRole;
	
	
	public User(String name, String surname, String email, Date birth, String gender, Date created, Long idRole){
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.created = created;
		this.status = true;
		this.idRole = idRole;
	
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
	public void updateName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void updateSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void updateStatus(boolean status) {
		this.status = status;
	}
	
	public Long getIdRole() {
		return idRole;
	}
	public void updateIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
	
}
