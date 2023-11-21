package com.rating.rating.Controller;


import com.rating.rating.Model.Rating;
import com.rating.rating.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RatingController {

    @Autowired
    RatingService ratingService;

    //  add users

    @PostMapping("/rating")
    public String addRating(@RequestBody Rating rating){
        return ratingService.addRating(rating);
    }

    // Get All User
    @GetMapping("/ratings")
    public List<Rating> getAllRating(){
        return ratingService.getAllRating();
    }

    //  Get User By Id
    @GetMapping("/rating/user/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable Integer userId){
        return ratingService.getRatingByUserId(userId);
    }


}

