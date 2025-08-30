package com.exam.portal;

import com.exam.portal.Model.Organiser;
import com.exam.portal.Repository.OrganiserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class HelloworldApplication implements CommandLineRunner {

	@Autowired
	OrganiserRepository repo;


	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(repo.findByEmail("ved@gmail.com") != null ){
			return;
		}

		Organiser organiser = new Organiser();
		organiser.setName("Vedant Malviya");
		organiser.setEmail("ved@gmail.com");
		organiser.setPassword(new BCryptPasswordEncoder().encode("password"));
		repo.save(organiser);

	}
}
