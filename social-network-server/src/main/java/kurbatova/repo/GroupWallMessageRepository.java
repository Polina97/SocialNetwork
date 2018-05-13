package kurbatova.repo;

import org.springframework.data.repository.CrudRepository;

import kurbatova.model.GroupWallMessage;

public interface GroupWallMessageRepository extends CrudRepository<GroupWallMessage, Long> {

}
