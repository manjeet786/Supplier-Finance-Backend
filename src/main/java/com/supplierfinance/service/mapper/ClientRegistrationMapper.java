package com.supplierfinance.service.mapper;

import com.supplierfinance.domain.ClientRegistration;
import com.supplierfinance.vo.ClientRegistrationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ClientRegistrationMapper {

    private static final Logger logger = LoggerFactory.getLogger(ClientRegistrationMapper.class);

    private ClientRegistrationMapper() {

    }

    public static ClientRegistration clientRegistrationVOtoEntity(ClientRegistrationVO to) {

        ClientRegistration from = null;

        if (null != to) {
            from = new ClientRegistration();
            from.setAddress(to.getAddress());
            from.setEmail(to.getEmail());
            from.setLoanAccountNumber(to.getLoanAccountNumber());
            from.setLoanInformation(to.getLoanInformation());
            from.setMobileNumber(to.getMobileNumber());
            from.setName(to.getName());
            from.setUserName(to.getUserName());
            from.setPassword(to.getPassword());

        }
        return from;
    }

    public static ClientRegistrationVO clientRegistrationEntitytoVO(ClientRegistration from) {

        ClientRegistrationVO to = null;

        if (null != from) {
            to = new ClientRegistrationVO();
            to.setAddress(from.getAddress());
            to.setEmail(from.getEmail());
            to.setLoanAccountNumber(from.getLoanAccountNumber());
            to.setLoanInformation(from.getLoanInformation());
            to.setMobileNumber(from.getMobileNumber());
            to.setName(from.getName());
            to.setUserName(from.getUserName());
            to.setPassword(from.getPassword());

        }
        return to;
    }

}
