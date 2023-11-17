package com.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String statusName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "transactionStatus")
    private List<Transaction> transactions;

    public TransactionStatus(String statusName){
        this.statusName=statusName;
    }
}