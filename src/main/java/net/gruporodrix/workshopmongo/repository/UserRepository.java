package net.gruporodrix.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.gruporodrix.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
