package com.cou.consumer.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="coupon_data")
public class Coupon {
	
	@Id
	@GeneratedValue
	private Integer cid;
	private String code;
	private  Double disAmt;
	private String expDate; 
}


