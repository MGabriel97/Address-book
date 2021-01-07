package book.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import book.backend.Service.ContactService;
import book.backend.dto.ContactDTO;
import book.backend.dto.SearchDTO;
import book.backend.entities.Contact;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "address")

public class AddressBookController {
	
	@Autowired
 	ContactService contactService;
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	//add a new contact
 	@PostMapping("/add")
	public Contact addContact(@RequestBody ContactDTO contactDTO)
	{
		return contactService.addContact(contactDTO);
	}
 	// return all contacts
 	@GetMapping("/getall")
	public List<ContactDTO> getAllContacts()
	{
 		List<Contact> contacts=contactService.findAllContacts();
 		List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
 		for(int i=0;i<contacts.size();i++)
 		{
 			contactDTOs.add(ContactDTO.fromEntity(contacts.get(i)));
 		}
		return contactDTOs;
	}

 	@GetMapping("/get/{id}")
	public Contact getContact(@PathVariable int id)
	{
		return contactService.findContact(id);
	}
 	
	@DeleteMapping("/delete/{id}")
	public void deleteContact(@PathVariable int id)
	{
		contactService.deleteContact(id);;
	}
	
 	@PostMapping("/update")
	public void editContact(@RequestBody ContactDTO contactDTO)
	{
		contactService.editContact(contactDTO);
	}
 	
 	//search for a contact's name and address
 	@PostMapping("/search")
	public List<ContactDTO> searchContact(@RequestBody SearchDTO searchDTO)
	{
 		List<Contact> contacts=contactService.search(searchDTO);
 		List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
 		for(int i=0;i<contacts.size();i++)
 		{
 			contactDTOs.add(ContactDTO.fromEntity(contacts.get(i)));
 		}
		return contactDTOs;
	}
}
