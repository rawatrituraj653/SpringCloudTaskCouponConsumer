package com.cou.consumer.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cou.consumer.model.Coupon;
import com.cou.consumer.repo.CouponRepository;

@Service
public class CouponService {

	@Autowired
	private CouponRepository repo;
	
	
	@Transactional
	public Integer saveCouponData(Coupon coupon) {
		
		Coupon coupon2=repo.save(coupon);
		Integer id=coupon2.getCid();
		return id;
	}

	
	public Coupon getCouponById(Integer id) {
		
		Optional<Coupon> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
			
		}
		else
			 return null;
		}
	
	
	public Coupon getCouponByCode(String code) {
		Optional<Coupon> cop=repo.findByCode(code);
		System.out.println(cop);
		if(cop.isPresent()) {
			return cop.get();
		}
		else {
				return null;
			}
		
	}
	
}
