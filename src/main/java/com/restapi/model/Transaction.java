package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private Long sourceAccount;

    private Long targetAccount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "transaction_type_id",referencedColumnName = "id")
    private TransactionType transactionType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private TransactionStatus transactionStatus;


    @CreationTimestamp
    private LocalDateTime localDateTime;

}
