package es.deusto.ingenieria.sd.strava.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.deusto.ingenieria.sd.strava.server.dao.UserRepository;
import es.deusto.ingenieria.sd.strava.server.model.User;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public enum UserServiceResult {
		SUCCESS,
		FAIL;
	}

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean login(String email, String contrasena) {
		Optional<User> result = userRepository.findById(email);
		if(result != null) {
			if(contrasena.equals("01")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
	public boolean comprobarUsuarioEmail(String email) {
		Optional <User> result = userRepository.findById(email);
		
		if(result != null) {
			return true;
		} else {
			return false;
		}
	}

	
}