package com.user.user.PayLoad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder        // to build the object of this calass pattern
public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;
}
