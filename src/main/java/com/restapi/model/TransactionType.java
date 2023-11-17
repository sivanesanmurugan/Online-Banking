package com.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionType {

    public static final String selfTransaction = "SELF_TRANSACTION";

    public static final String sameBankTransaction = "SAME_BANK_TRANSACTION";

    public static final String otherBankTransaction= "OTHER_BANK_TRANSACTION";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionTypeName;

    @OneToMany(mappedBy = "transactionType")
    private List<Transaction> transactionList;
}
