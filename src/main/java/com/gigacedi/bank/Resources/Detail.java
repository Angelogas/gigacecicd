package com.gigacedi.bank.Resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "detail")
public class Detail {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id ;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    private String phone;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne
    @JoinColumn (name = "detail_id")
    private Customer customer;
}
