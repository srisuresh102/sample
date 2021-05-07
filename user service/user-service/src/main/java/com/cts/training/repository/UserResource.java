package com.cts.training.repository;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bean.User;
import com.cts.training.exception.UserNotFoundException;

@RestController
@RequestMapping("/api") //http://localhost:8082/api/users
public class UserResource {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<Optional<User>> getUserId(@PathVariable Long id){
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("The user with id - does not exist");
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		
userRepository.deleteById(id);		

	}
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		User savedUser= userRepository.save(user);
	return savedUser;
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@Valid @RequestBody User user, @PathVariable Long id){
		Optional<User> updatedUser= userRepository.findById(id);
		if(!updatedUser.isPresent())
			throw new UserNotFoundException("The user with id - does not exist");
		 	
	userRepository.save(user);
	return ResponseEntity.noContent().build();
	
	}
}
