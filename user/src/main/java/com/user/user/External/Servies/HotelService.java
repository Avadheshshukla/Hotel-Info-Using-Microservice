package com.user.user.External.Servies;

import com.user.user.Model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    //no need to write anything because we are using feign client
    // declaritive approach

    @GetMapping("/hotel/id/{hotelId}")
  Hotel getHotel(@PathVariable("hotelId") Integer hotelId);

}
