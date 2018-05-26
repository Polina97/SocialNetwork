package kurbatova.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.User;
import kurbatova.model.UserRole;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT u FROM User u where u.login = :login AND u.password = :password")
	User findByLoginPassword(@Param("login") String login, @Param("password") String password);
	
	@Query("SELECT u FROM User u WHERE u.userRole = :userRole")
	List<User> findByUserRole(@Param("userRole") UserRole userRole);
}
