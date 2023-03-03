package com.supplierfinance.service;

import com.supplierfinance.vo.ClientRegistrationVO;
import com.supplierfinance.vo.SupplierRegistrationVO;

public interface RegistrationService {

    ClientRegistrationVO registerClient(ClientRegistrationVO clientRegistrationVO);

    SupplierRegistrationVO registerSupplier(SupplierRegistrationVO supplierRegistrationVO);
}
