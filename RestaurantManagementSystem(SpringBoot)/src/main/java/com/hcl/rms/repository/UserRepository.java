package com.hcl.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.rms.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
	public User findByUserName(String userName);

}
