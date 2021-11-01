package com.esms.ms;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name) {
		User n = new User();
		n.setName(name);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteUsers(@PathParam(value = "id") Integer id) {
		userRepository.deleteById(id);
		
		return "deleted user id"+id;
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<User> getUser(@PathParam(value = "id") Integer id) {
		return userRepository.findById(id);
	}
}
