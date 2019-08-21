package com.cou.consumer.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cou.consumer.model.Coupon;

public interface CouponRepository  extends JpaRepository<Coupon, Integer>{

	public Optional<Coupon> findByCode(String code);
}
