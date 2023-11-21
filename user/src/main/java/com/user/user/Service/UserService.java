package com.user.user.Service;

import com.user.user.Exception.ResourceNotFound;
import com.user.user.External.Servies.HotelService;
import com.user.user.Model.Hotel;
import com.user.user.Model.Rating;
import com.user.user.Model.User;
import com.user.user.Repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {



    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;



    private Logger logger = LoggerFactory.getLogger(UserService.class);


    public String addUser(User user) {
        userRepo.save(user);
        return user.getName()+" Registered Successfully!!!";
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("Given user id is not found on server!!: " + userId));
     // fetch rating of above user from rating service
        // rating bu user id  = http://localhost:8083/rating/id/1

      Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserId(), Rating[].class);
       logger.info("Ratings: {}",ratingsOfUser);

       List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //      http://localhost:8082/hotel/id/1
           // Hotel hotel = hotelService.getHotel(rating.getHotelId());
          ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/id/"+user.getUserId(), Hotel.class);
          Hotel hotel = forEntity.getBody();
          logger.info("Response Status Code: {}",forEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);

            //return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
      return user;
    }
}
