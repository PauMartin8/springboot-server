package es.deusto.ingenieria.sd.springboot.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.deusto.ingenieria.sd.springboot.server.dao.UserRepository;
import es.deusto.ingenieria.sd.springboot.server.model.User;

@SpringBootApplication
public class ServerApplication {

	private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			//Create some users
			repository.save(new User("John", "Doe", "john.doe@example.com"));
			repository.save(new User("Ada", "Lovelace", "ada.lovelace@example.com"));
			repository.save(new User("Alan", "Turing", "alan.turing@example.com"));
			repository.save(new User("Grace", "Hopper", "grace.hopper@example.com"));
			repository.save(new User("Linus", "Torvalds", "linus.torvalds@example.com"));
			repository.save(new User("Margaret", "Hamilton", "margaret.hamilton@example.com"));
			repository.save(new User("Steve", "Jobs", "steve.jobs@example.com"));
			repository.save(new User("Bill", "Gates", "bill.gates@example.com"));
			repository.save(new User("Tim", "Berners-Lee", "tim.bernerslee@example.com"));
			repository.save(new User("Suzanne", "Simard", "suzanne.simard@example.com"));
						
			log.warn("USER Service available and waiting ...");
		};
	}
}