package kurbatova.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

	@Query(value = "SELECT * FROM profile p where p.user_id = :userId LIMIT 1", 
	    nativeQuery=true
	)
	Profile getProfileByUserId(@Param("userId") String userId);
	
}
