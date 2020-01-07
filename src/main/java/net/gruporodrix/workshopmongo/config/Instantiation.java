package net.gruporodrix.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import net.gruporodrix.workshopmongo.domain.Post;
import net.gruporodrix.workshopmongo.domain.User;
import net.gruporodrix.workshopmongo.dto.AuthorDTO;
import net.gruporodrix.workshopmongo.repository.PostRepository;
import net.gruporodrix.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User andreas = new User(null, "Andreas Freitas", "andreas@rodrix.net");
		User sarah = new User(null, "Sarah Rodrix", "sarah@rodrix.net");
		User samuel = new User(null, "Samuel Rodrix", "samuel@rodrix.net");
		userRepository.saveAll(Arrays.asList(andreas, sarah, samuel));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou Viajar pra São Paulo! Abraços!", new AuthorDTO(sarah));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia!", "Acordei Feliz Hoje!", new AuthorDTO(sarah));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		sarah.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(sarah);
	}

}
