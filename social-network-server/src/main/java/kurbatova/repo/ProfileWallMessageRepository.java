package kurbatova.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kurbatova.model.Profile;
import kurbatova.model.ProfileWallMessage;

public interface ProfileWallMessageRepository extends CrudRepository<ProfileWallMessage, Long> {

	List<ProfileWallMessage> findAllByMessageOwner(Profile profile);
}
