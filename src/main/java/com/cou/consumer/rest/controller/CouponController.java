package com.cou.consumer.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cou.consumer.model.Coupon;
import com.cou.consumer.service.CouponService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/cop")
public class CouponController {

	@Autowired
	private CouponService service;

	@PostMapping("/save")	
	@HystrixCommand(fallbackMethod = "saveFallBack")	
	public String saveCoupon(@RequestBody Coupon coupon ) {
		
		Integer id=service.saveCouponData(coupon);
		if(id>0){
			return "This coupon data inserted with id:"+id;
		}
		else {
			return "some Error occured with data";
		}
	} 
	
	public String  saveFallBack(@RequestBody Coupon coupon) {
		
		return "some Error Occured Sorry ";
	}
	
	@GetMapping("/getdata/{id}")
	public Coupon getCoupon(@PathVariable ("id") Integer id) {
		Coupon  coupon=service.getCouponById(id);
		return coupon; 
	}
	
	@PostMapping("/getBycode")
	public Coupon getCopByCode(@RequestParam ("code") String code) {
		System.err.println("Coupon value come from product :"+code);
		Coupon coupon=service.getCouponByCode(code);
		System.out.println(coupon);
		return coupon;
	}
}
