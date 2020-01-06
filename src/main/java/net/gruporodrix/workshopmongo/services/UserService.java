package net.gruporodrix.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.gruporodrix.workshopmongo.domain.User;
import net.gruporodrix.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	public List<User> findAll(){
		return repo.findAll();
	}
}

