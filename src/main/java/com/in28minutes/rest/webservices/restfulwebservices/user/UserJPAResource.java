package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.post.Post;

@RestController
public class UserJPAResource {
	
	
	@Autowired 
	private UserRepository userRepository;
	
	
	@GetMapping(path="/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping(path="/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		//HATEOAS 
		//Creating a link
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		resource.add(link.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uriLocation).build();
	}
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id - " + id);
		}
		userRepository.delete(user.get());
	}
	
	@GetMapping(path="/jpa/users/{id}/posts")
	public List<Post> retrieveAllPssts(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - " + id);
		}
		return user.get().getPosts();
	}
	
}
