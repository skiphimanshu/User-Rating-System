package com.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE", path = "/hotel")
public interface HotelService {
	
	@PostMapping("/{hotelId}")
	Hotel getHotelById(@PathVariable String hotelId);
}
