package com.restapi.request;

import com.restapi.model.TransactionStatus;
import com.restapi.model.TransactionType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionRequest {

    private Long id;

    private Long sourceAccount;

    private Long targetAccount;

    private Long transactionType;

    private Long transactionStatus;

    private double amount;

}
