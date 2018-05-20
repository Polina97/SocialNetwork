package kurbatova.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.ProfileFriend;

public interface ProfileFriendRepository extends CrudRepository<ProfileFriend, Long> {

	@Query(value = "SELECT * FROM profile_friend pf WHERE (pf.profile_id = :profileId OR friend_id =:profileId) && status = :status", 
		    nativeQuery=true
		)
	List<ProfileFriend> findProfileByFriendStatus(@Param("profileId")Long profileId, @Param("status") String status);
	
	@Query(value = "SELECT * FROM profile_friend pf WHERE pf.profile_id != :profileId && friend_id != :profileId", 
		    nativeQuery=true
		)
	List<ProfileFriend> findFriends(@Param("profileId")Long profileId);
	
	@Query(value = "SELECT * FROM profile_friend pf WHERE pf.profile_id = :profileId AND friend_id =:friendId", 
		    nativeQuery=true
		)
	Optional<ProfileFriend> findFriendPair(@Param("profileId")Long profileId, @Param("friendId")Long friendId);
}
