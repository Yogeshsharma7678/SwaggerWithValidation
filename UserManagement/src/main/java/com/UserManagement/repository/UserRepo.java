package com.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.UserManagement.model.user;

@Repository
public interface UserRepo extends JpaRepository<user, Integer>{

	@Query(value="select * from user where user_id=?1", nativeQuery=true)
	user findByUserId(int id);

}
