package kurbatova.repo;

import org.springframework.data.repository.CrudRepository;

import kurbatova.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}
