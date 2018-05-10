package kurbatova.repo;

import org.springframework.data.repository.CrudRepository;

import kurbatova.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {

}
