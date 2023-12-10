package es.deusto.ingenieria.sd.strava.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.deusto.ingenieria.sd.strava.server.dao.UserRepository;
import es.deusto.ingenieria.sd.strava.server.model.User;

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
			repository.save(new User("jaime@open.com", "01"));
			repository.save(new User("eneko@open.com", "02"));
			repository.save(new User("pau@open.com", "03"));
			repository.save(new User("markel@open.com", "04"));
						
			log.warn("USER Service available and waiting ...");
		};
	}
}