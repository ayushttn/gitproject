package com.springcloud.repos;

import com.springcloud.model.Coupon;
import org.springframework.data.repository.CrudRepository;

public interface CouponRepo extends CrudRepository<Coupon, Long> {
    Coupon findByCode(String code);
}
