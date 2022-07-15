package com.gigacedi.bank.Resources;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "account_number")
    private int accountNumber;
    @Column (name = "routing_number")
    private int routingNumber;
    @Column (name = "account_type")
    private AccountType accountType;
    @Column (name = "balance")
    private double balance;
    @ManyToOne
    @JoinColumn (name = "account_id")
    private Customer customer;

}
