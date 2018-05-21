package kurbatova.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.PersonalMessage;

public interface PersonalMessageRepository extends CrudRepository<PersonalMessage, Long> {
	
	@Query(value = "SELECT * FROM personal_message pm, personal_message_profile pmp WHERE (pm.owner_id = :ownerId AND pmp.profile_id = :targetId) "
			+ "OR (pm.owner_id = :targetId AND pmp.profile_id = :ownerId)", 
		    nativeQuery=true
		)
	List<PersonalMessage> getAllMessages(@Param("ownerId") Long ownerId, @Param("targetId") Long targetId);
}
