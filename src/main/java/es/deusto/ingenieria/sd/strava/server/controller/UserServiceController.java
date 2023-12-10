package es.deusto.ingenieria.sd.strava.server.controller;

import java.util.StringTokenizer;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.deusto.ingenieria.sd.strava.server.service.UserService;

@RestController
public class UserServiceController {
	private static final Logger log= LoggerFactory.getLogger(UserServiceController.class);	

    private UserService service;
    
    public UserServiceController(UserService userService) {
        this.service = userService;
    }
    
    @PostMapping("/strava/login")
    public boolean login(@RequestBody String message) {
    	
    	System.out.println(message);
    	
    	StringTokenizer tokenizer = new StringTokenizer(message, "#");
    	
    	String email = tokenizer.nextToken();
    	String contrasena = tokenizer.nextToken();
    	
    	log.warn(String.format("Obteniendo usuario con email {%s} y contrasena {%s} ...", email, contrasena));
    	
    	if(service.login(email, contrasena)) {
    		return true;
    	} else {    		
    		return false;
    	}
    }

    @PostMapping("/strava/comprobarUsuario")
    public boolean comprobarUsuario(@RequestBody String email) {
    	log.warn(String.format("Getting user by id {%s} ...", email));
        if(service.comprobarUsuarioEmail(email)) {
        	return true;
        } else {
        	return false;
        }
    }
}