package com.hcl.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.rms.entities.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	public Admin findByAdminName(String adminName);

}
