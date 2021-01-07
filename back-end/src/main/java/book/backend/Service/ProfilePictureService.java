package book.backend.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import book.backend.entities.Contact;
import book.backend.entities.ProfilePicture;
import book.backend.repository.ContactRepository;
import book.backend.repository.ProfilePictureRepostory;

@Service
public class ProfilePictureService {
private final ProfilePictureRepostory profilePictureRepostory;
private final ContactRepository contactRepository;
	
	@Autowired
	public ProfilePictureService(ProfilePictureRepostory profilePictureRepostory,
			ContactRepository contactRepository)
	{
		this.contactRepository=contactRepository;
		this.profilePictureRepostory=profilePictureRepostory;
	}
	//image is saved as a BLOB in database
	public  void updateProfile(Integer id,MultipartFile file) throws IOException {
		Contact contact=contactRepository.findById(id).get();
			ProfilePicture picture = contact.getPicture();
		    if (picture == null)
		    	picture = new ProfilePicture(id); 
		    picture.setImage(file.getBytes());
		     profilePictureRepostory.save(picture);	
	}
	
	public ProfilePicture getImage(Integer id) throws IOException {

		final ProfilePicture retrievedImage = profilePictureRepostory.findById(id).get();
		return retrievedImage;
	}
	
	public String deleteImage(Integer id) throws IOException {

		profilePictureRepostory.deleteById(id);;
		return "Deleted";
	}
	
	
}
