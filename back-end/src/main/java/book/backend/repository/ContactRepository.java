package book.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import book.backend.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	
	@Query(value = "SELECT c FROM Contact c "
    		+ "WHERE c.name LIKE %:nameContact% "
    		+ "AND c.address LIKE %:addressContact% ")
 	//search for a contact's name and address
	List<Contact> searchContact(String nameContact,String addressContact);
}
