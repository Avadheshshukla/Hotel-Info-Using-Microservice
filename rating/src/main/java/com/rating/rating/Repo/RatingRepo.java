package com.rating.rating.Repo;

import com.rating.rating.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
    List<Rating> findByUserId(Integer userId);
}
