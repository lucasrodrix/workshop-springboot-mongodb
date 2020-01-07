package net.gruporodrix.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.gruporodrix.workshopmongo.domain.Post;
import net.gruporodrix.workshopmongo.repository.PostRepository;
import net.gruporodrix.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Requested id=%s does not found", id)));
	}
}