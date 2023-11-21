package com.user.user.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 20)
    private Integer userId;

    @Column(name = "NAME", length = 20)
    private String name;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

    @Column(name = "Contact Number", length = 15)
    private Long contact;
    private LocalDate date;


    @Transient   // do not save this in database
    private List<Rating> ratings = new ArrayList<>();   // will get rating from microservices class

}
