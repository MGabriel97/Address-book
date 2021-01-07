package book.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import book.backend.entities.ProfilePicture;

public interface ProfilePictureRepostory extends  JpaRepository<ProfilePicture, Integer>{

}
