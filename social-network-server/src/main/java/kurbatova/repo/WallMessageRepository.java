package kurbatova.repo;

import org.springframework.data.repository.CrudRepository;

import kurbatova.model.WallMessage;

public interface WallMessageRepository extends CrudRepository<WallMessage, Long> {

}
