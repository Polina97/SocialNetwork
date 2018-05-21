package kurbatova.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.PersonalMessageProfile;

public interface PersonalMessageProfileRepository extends CrudRepository<PersonalMessageProfile, Long> {

	@Query(value = "SELECT * FROM personal_message_profile pmf, profile p, personal_message pm WHERE pmf.profile_id = :profileId OR pmf.personal_message_id IN "
			+ "(SELECT id FROM personal_message pm WHERE owner_id = :profileId)", 
		    nativeQuery=true
		)
	Set<PersonalMessageProfile> getDialogs(@Param("profileId")Long profileId);
}
