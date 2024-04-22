package com.hcl.rms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.rms.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	public List<Order> findByUserId(long userId);

	public List<Order> findByDate(LocalDate date);

	@Query("select sum(totalAmount) from order_table where date IN(?1)")
	public  int calculateBillByDate(LocalDate date);
	
	@Query("select sum(totalAmount) from order_table")
	public int totalMonthlyBill(LocalDate date);
}
