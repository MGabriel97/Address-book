package book.backend.dto;

import book.backend.entities.Contact;

public class ContactDTO {
	
	public int id;
	public String name;
	public String address;
	
	public static ContactDTO fromEntity(Contact contact)
	{
		ContactDTO contactDTO=new ContactDTO();
		contactDTO.id=contact.getId();
		contactDTO.name=contact.getName();
		contactDTO.address=contact.getAddress();	
		return contactDTO;
	}
	
	public static Contact toEntity(ContactDTO contactDTO)
	{
		return new Contact(contactDTO.name,contactDTO.address);
	}
}
