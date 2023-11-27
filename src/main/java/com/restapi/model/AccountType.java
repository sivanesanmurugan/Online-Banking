package com.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "accountType")
    private List<Account> account;

}
