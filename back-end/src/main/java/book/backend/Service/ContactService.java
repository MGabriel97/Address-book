package book.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.backend.dto.ContactDTO;
import book.backend.dto.SearchDTO;
import book.backend.entities.Contact;
import book.backend.repository.ContactRepository;

@Service
public class ContactService {
	private final ContactRepository contactRepository;
	
	@Autowired
	public ContactService(ContactRepository contactRepository)
	{
		this.contactRepository=contactRepository;
	}
	
	public Contact addContact(ContactDTO contactDTO)
	{
		return contactRepository.save(ContactDTO.toEntity(contactDTO));
	}
	
	public List<Contact> findAllContacts()
	{
		return contactRepository.findAll();
	}
	
	public Contact findContact(int id)
	{
		Contact deleteContact = contactRepository.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		return deleteContact;
	}
	
	public void deleteContact(int id)
	{
		Contact deleteContact = contactRepository.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		contactRepository.delete(deleteContact);;
	}
	
	public void editContact(ContactDTO contactDTO)
	{
		Contact editContact=contactRepository.findById(contactDTO.id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + contactDTO.id));
		editContact.setAddress(contactDTO.address);
		editContact.setName(contactDTO.name);
		contactRepository.save(editContact);
	}
	
	public List<Contact> search(SearchDTO searchDTO)
	{
		return contactRepository.searchContact(searchDTO.name, searchDTO.address);
	}
		
		
}
