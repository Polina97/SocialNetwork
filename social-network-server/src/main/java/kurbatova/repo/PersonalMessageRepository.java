package kurbatova.repo;

import org.springframework.data.repository.CrudRepository;

import kurbatova.model.PersonalMessage;

public interface PersonalMessageRepository extends CrudRepository<PersonalMessage, Long> {

}
