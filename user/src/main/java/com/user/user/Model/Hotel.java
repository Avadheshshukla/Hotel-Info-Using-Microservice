package com.user.user.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private Integer hotelId;
    private String hotelName;
    private String hotelBio;
    private String hotelAddress;
    private Long contactNo;
}
