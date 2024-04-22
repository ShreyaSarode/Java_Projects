package com.hcl.rms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.rms.entities.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
		
		
		public Menu findByItemName( String itemName);
		
		
		public Menu findByPrice( String itemName);
		
		
		//delete Menu by itemId
		@Transactional
		@Modifying
		@Query("delete menu m where m.itemId = ?1")
		public void deleteMenuById(long itemId);
	
	
	

}
