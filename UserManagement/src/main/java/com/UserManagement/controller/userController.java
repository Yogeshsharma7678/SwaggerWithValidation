package com.UserManagement.controller;

import java.util.List;

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

import com.UserManagement.dto.UserDTO;
import com.UserManagement.exception.GlobalException;
import com.UserManagement.model.user;
import com.UserManagement.service.UserService;

@RestController
@RequestMapping("/user")
public class userController {

	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public ResponseEntity<user> addUser(@RequestBody @Valid UserDTO u){
		
		return new ResponseEntity<>(service.addUser(u) , HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<user>> getUser(){
		
		return new ResponseEntity<>(service.getUser(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<user> deleteUser(@PathVariable int id) throws GlobalException{
		
        		return new ResponseEntity<> (service.deleteUser(id),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/")
	public ResponseEntity<user> updateUser(@RequestBody @Valid UserDTO u) throws GlobalException{
		
		return new ResponseEntity<> (service.addUser(u), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<user> getUserById (@PathVariable int id) throws GlobalException{
		
		return new ResponseEntity<> (service.getUserById(id), HttpStatus.OK);
	}
}
















