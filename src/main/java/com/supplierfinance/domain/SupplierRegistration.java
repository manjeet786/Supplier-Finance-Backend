package com.supplierfinance.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="supplier_registration")
public class SupplierRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="credit_account_number",unique = true,nullable = false)
    private Long creditAccountNumber;

    @Column(name ="name")
    private String name;

    @Column(name ="address")
    private String address;

    @Column(name ="email")
    private String email;

    @Column(name ="mobile_number")
    private String mobileNumber;

    @Column(name ="credit_information")
    private String creditInformation;

    @Column(name ="username")
    private String userName;

    @Column(name ="password")
    private String password;
}
