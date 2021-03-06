package kurbatova.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

	@Query(value = "SELECT * FROM profile p, profile_wall_message pw, profile_photo pf WHERE p.id = :profileId AND pf.current = true", 
		    nativeQuery=true
		)
	Set<Profile> getProfileByProfileId(@Param("profileId") String profileId);
	
	@Query(value = "SELECT * FROM profile p WHERE p.user_id = :userId", 
		    nativeQuery=true
		)
	Profile getByUserId(@Param("userId")Long userId);
	
	@Query(value = "SELECT * FROM social_network.profile p WHERE p.id IN :profileIds", 
		    nativeQuery=true
		)
	Set<Profile> getProfilesById(@Param("profileIds") Iterable<Long> profileIds);
}