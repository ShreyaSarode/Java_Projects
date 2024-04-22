package com.hcl.rms.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity(name = "order_table")
public class Order {
	
	@Id
	private long orderId;
	private long userId;
	private String itemName;
	private int totalAmount;
	private int quantity;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;

	
	

}
