package net.gruporodrix.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.gruporodrix.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User renata = new User("1", "Renata", "renata@rodrix.net");
		User sarah = new User("2", "Sarah Rodrix", "sarah@rodrix.net");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(renata, sarah));
		return ResponseEntity.ok().body(list);
	}
}
