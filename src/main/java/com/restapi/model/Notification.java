package com.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Notification {

    public static final String MINIMUM_BALANCE = "Please Maintain The Minimum Balance";

    @Id
    @GeneratedValue
    private Long id;

    private String alertStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    private boolean isNotified = false;
}
