package kurbatova.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

	@Query(value = "SELECT * FROM user_role ur WHERE ur.name = :roleName", 
		    nativeQuery=true
		)
	Optional<UserRole> findByName(@Param("roleName")String name);
}
