package com.UserManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserManagement.dto.UserDTO;
import com.UserManagement.exception.GlobalException;
import com.UserManagement.model.user;
import com.UserManagement.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public user addUser (UserDTO u) {
		
		user u1 = user.build(u.getUserId(),u.getUserName(), u.getUserPhone(), u.getUserEmail(), u.getUserPassword());
		
		return repo.save(u1);
	}
	
	public List<user> getUser(){
		
		return repo.findAll();
	}
	
	public user deleteUser(int id) throws GlobalException{
		
		user _u1 = repo.findByUserId(id);
		
		if(_u1!=null) {
			
			repo.deleteById(id);
			
			return _u1;
		}
		else{
			throw new GlobalException("user not found!...");
		}
		
	}
	
	public user updateUser(UserDTO u) {
		
		user u1= user.build(u.getUserId(), u.getUserName(), u.getUserEmail(), u.getUserPhone(), u.getUserPassword());
		
		return repo.save(u1);
	}
	
	public user getUserById(int id) throws GlobalException{
		
		user _u1 = repo.findByUserId(id);
				
	    if(_u1!=null) {
	    	
	    	return _u1;
	    }
	    else {
	    	
	    	throw new GlobalException("user not found");
	    }
		
	}
	
	
	
	
	
}









