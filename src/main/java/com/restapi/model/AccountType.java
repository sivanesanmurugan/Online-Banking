package com.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountType {

    public static final String SAVING_ACCOUNT = "SAVING_ACCOUNT";

    public static final String INVESTMENT_ACCOUNT = "INVESTMENT_ACCOUNT";

    @Id
    @GeneratedValue
    private Integer id;

    private String accountType;

    @OneToOne(mappedBy = "accountType")
    private Account account;

}
