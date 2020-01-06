package net.gruporodrix.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import net.gruporodrix.workshopmongo.domain.User;
import net.gruporodrix.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User andreas = new User(null, "Andreas Freitas", "andreas@rodrix.net");
		User sarah = new User(null, "Sarah Rodrix", "sarah@rodrix.net");
		User samuel = new User(null, "Samuel Rodrix", "samuel@rodrix.net");
		
		userRepository.saveAll(Arrays.asList(andreas, sarah, samuel));
	}

}
