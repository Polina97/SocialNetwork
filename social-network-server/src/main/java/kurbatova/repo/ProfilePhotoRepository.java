package kurbatova.repo;

import org.springframework.data.repository.CrudRepository;

import kurbatova.model.ProfilePhoto;

public interface ProfilePhotoRepository extends CrudRepository<ProfilePhoto, Long> {

}
