package com.supplierfinance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="client_registration",schema="public")
@NoArgsConstructor
public class ClientRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="loan_account_number",unique = true,nullable = false)
    private Long loanAccountNumber;

    @Column(name ="name")
    private String name;

    @Column(name ="address")
    private String address;

    @Column(name ="email")
    private String email;

    @Column(name ="mobile_number")
    private String mobileNumber;

    @Column(name ="loan_info")
    private String loanInformation;

    @Column(name ="username")
    private String userName;

    @Column(name ="password")
    private String password;
}
