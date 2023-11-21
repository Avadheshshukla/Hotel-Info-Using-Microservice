package com.rating.rating.Service;

import com.rating.rating.Model.Rating;
import com.rating.rating.Repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    RatingRepo ratingRepo;

    public String addRating(Rating rating) {
        ratingRepo.save(rating);
        return rating.getRatings()+" rated on this "+rating.getHotelId();
    }

    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }


    public List<Rating> getRatingByUserId(Integer userId) {
        return ratingRepo.findByUserId(userId);
    }
}
