package com.supplierfinance.service.mapper;

import com.supplierfinance.domain.SupplierRegistration;
import com.supplierfinance.vo.SupplierRegistrationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupplierRegistrationMapper {
    private static final Logger logger = LoggerFactory.getLogger(SupplierRegistrationMapper.class);

    private SupplierRegistrationMapper() {

    }

    public static SupplierRegistration supplierRegistrationVOtoEntity(SupplierRegistrationVO to) {

        SupplierRegistration from = null;

        if (null != to) {
            from = new SupplierRegistration();
            from.setAddress(to.getAddress());
            from.setEmail(to.getEmail());
            from.setCreditAccountNumber(to.getCreditAccountNumber());
            from.setCreditInformation(to.getCreditInformation());
            from.setMobileNumber(to.getMobileNumber());
            from.setName(to.getName());

        }
        return from;
    }
}
