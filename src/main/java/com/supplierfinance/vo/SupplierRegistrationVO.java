package com.supplierfinance.vo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierRegistrationVO {

    private String name;

    private String address;

    private String email;

    private String mobileNumber;

    private Long creditAccountNumber;

    private String creditInformation;

    private String userName;

    private String password;
}
