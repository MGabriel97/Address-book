package book.backend.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;

import book.backend.Service.ProfilePictureService;
import book.backend.entities.ProfilePicture;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfilePictureController {
private final ProfilePictureService profilePictureService;
	
	@Autowired
	public ProfilePictureController(ProfilePictureService profilePictureService)
	{
		this.profilePictureService=profilePictureService;
	}
	
	@PostMapping("/addimage/{id}")
	public  void updateProfile(@PathVariable int id,@RequestParam("image") MultipartFile file) throws IOException {
		profilePictureService.updateProfile(id, file);;
	}
	
	@GetMapping(path = { "/getimage/{id}" })
	public ProfilePicture getImage(@PathVariable Integer id) throws IOException {
		return profilePictureService.getImage(id);
	}
	
	@DeleteMapping(path = { "/deleteimage/{id}" })
	public String deleteImage(@PathVariable Integer id) throws IOException {
		return profilePictureService.deleteImage(id);
	}
}
