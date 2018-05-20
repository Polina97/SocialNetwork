package kurbatova.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kurbatova.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {

	@Query(value = "SELECT * FROM social_network.group", nativeQuery=true)
	List<Group> getAll();
}
