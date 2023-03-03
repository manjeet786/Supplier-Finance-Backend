package com.supplierfinance.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientRegistrationVO {

    private String name;

    private String address;

    private String email;

    private String mobileNumber;

    private Long loanAccountNumber;

    private String loanInformation;

    private String userName;

    private String password;

}

