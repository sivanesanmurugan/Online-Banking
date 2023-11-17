package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long account_No;

    private String ifsc_Code;

    private Double balance;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "acc_type_id", referencedColumnName = "id")
    private AccountType accountType;

    private boolean isBoolean=false;

}
