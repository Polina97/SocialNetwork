package kurbatova.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kurbatova.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT u FROM User u where u.login = :login AND u.password = :password")
	User findByLoginPassword(@Param("login") String login, @Param("password") String password);
}
