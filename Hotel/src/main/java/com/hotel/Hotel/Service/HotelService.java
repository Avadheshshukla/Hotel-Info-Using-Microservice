package com.hotel.Hotel.Service;

import com.hotel.Hotel.Exception.ResourceNotFoundException;
import com.hotel.Hotel.Model.Hotel;
import com.hotel.Hotel.Repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;

    public String addHotel(Hotel hotel) {
        hotelRepo.save(hotel);
        return hotel.getHotelName()+" registered Successfully!!!";
    }

    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();

    }

    public Optional<Hotel> getHotelById(Integer hotelId) {

        return Optional.ofNullable(hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found : "+ hotelId)));
    }
}
