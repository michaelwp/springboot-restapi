package com.appdeveloperblog.pp.ws.ui.controller;

import com.appdeveloperblog.pp.ws.ui.model.request.UserDetailsRequestModel;
import com.appdeveloperblog.pp.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

	@GetMapping
	public String getUsers(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
	) {
		return "get user was called page = " + page + ", limit = " + limit + ", sort = " + sort;
	}

	@GetMapping(path="/{userId}", produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest returnValue = new UserRest();

		returnValue.setFirstName("Michael");
		returnValue.setLastName("Putong");
		returnValue.setEmail("michael.putong@mputong.com");

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PostMapping(consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	}, produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

		UserRest returnValue = new UserRest();

		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}

}
