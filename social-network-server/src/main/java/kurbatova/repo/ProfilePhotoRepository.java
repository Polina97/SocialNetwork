package kurbatova.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kurbatova.model.Profile;
import kurbatova.model.ProfilePhoto;

public interface ProfilePhotoRepository extends CrudRepository<ProfilePhoto, Long> {

	List<ProfilePhoto> findByProfileAndCurrent(Profile profile, Boolean isCurrent);
}
