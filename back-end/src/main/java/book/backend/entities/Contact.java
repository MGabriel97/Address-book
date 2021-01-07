package book.backend.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Contact {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer id;
	 
	 @Column(name = "name")
	 private String name;
	
	 @Column(name = "address",nullable = false)
	 private String address;
	 
	 @JsonManagedReference
	 @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
     private ProfilePicture picture;
	
	
	public Contact(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public Contact(String name, String address, ProfilePicture picture) {
		super();
		this.name = name;
		this.address = address;
		this.picture = picture;
	}

	public Contact(Integer id, String name, String address, ProfilePicture picture) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.picture = picture;
	}
	
	public Integer getId() {
			return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ProfilePicture getPicture() {
		return picture;
	}

	public void setPicture(ProfilePicture picture) {
		this.picture = picture;
	}

	public Contact() {
		super();
	}

	


	
	

	
	 
	 
}
