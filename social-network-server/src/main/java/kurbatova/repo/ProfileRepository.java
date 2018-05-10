package kurbatova.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.Profile;
import kurbatova.model.User;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
	
	@Query("SELECT p.profileId, p.firstName, p.lastName, p.birthDay FROM Profile p where p.user = :user")
	Profile getProfileById(@Param("user") User user);
}
