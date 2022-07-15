package com.gigacedi.bank.Resources;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Table (name = "address")
public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "street_address_one")
    private String streetAddressOne;
    @Column (name = "street_address_two")
    private String streetAddressTwo;
    private String city;
    @Column (name = "zip_code")
    private String zipCode;

    private STATE state;
    @OneToOne(mappedBy = "address")
    private Detail detail;

}
