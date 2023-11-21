package com.user.user.Model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private Integer ratingId;
    private Integer hotelId;
    private Integer userId;
    private String ratings;
    private String feedback;
    private LocalDate Date;

    private Hotel hotel;
}
