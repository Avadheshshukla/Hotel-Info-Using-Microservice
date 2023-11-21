package com.hotel.Hotel.Repo;

import com.hotel.Hotel.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {
}
