package book.backend.entities;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;


@Entity
@Table(name = "picture")
public class ProfilePicture {
	@Id
    @Column(name = "id")
		private Integer id;
	
	@Column(name = "image", length = 2500)
		private byte[] image;
	
	@OneToOne
	@JsonBackReference
    @PrimaryKeyJoinColumn
    private Contact contact;

	public ProfilePicture(Integer id, byte[] image, Contact contact) {
		super();
		this.id = id;
		this.image = image;
		this.contact = contact;
	}

	public ProfilePicture(byte[] image) {
		super();
		this.image = image;
	}

	public ProfilePicture(Integer id) {
		super();
		this.id = id;
	}

	public ProfilePicture(byte[] image, Contact contact) {
		super();
		this.image = image;
		this.contact = contact;
	}

	public ProfilePicture(Integer id, byte[] image) {
		super();
		this.id = id;
		this.image = image;
	}

	public ProfilePicture() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	
	
	
}
