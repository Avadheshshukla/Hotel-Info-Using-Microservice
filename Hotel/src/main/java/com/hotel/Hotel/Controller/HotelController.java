package com.hotel.Hotel.Controller;

import com.hotel.Hotel.Model.Hotel;
import com.hotel.Hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    //  add users

    @PostMapping("/hotel")
    public String addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    // Get All User
    @GetMapping("/hotels")
    public List<Hotel> getAllHotel(){
        return hotelService.getAllHotel();
    }

    //  Get User By Id
    @GetMapping("/hotel/id/{hotelId}")
    public Optional<Hotel> getHotelById(@PathVariable Integer hotelId){
        return hotelService.getHotelById(hotelId);
    }

}
