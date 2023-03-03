package com.supplierfinance.service.Impl;


import com.supplierfinance.repository.ClientRegistrationRepository;
import com.supplierfinance.repository.SupplierRegistrationRepository;
import com.supplierfinance.service.RegistrationService;
import com.supplierfinance.service.mapper.ClientRegistrationMapper;
import com.supplierfinance.service.mapper.SupplierRegistrationMapper;
import com.supplierfinance.vo.ClientRegistrationVO;
import com.supplierfinance.vo.SupplierRegistrationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    private SupplierRegistrationRepository supplierRegistrationRepository;

    @Override
    public ClientRegistrationVO registerClient(ClientRegistrationVO clientRegistrationVO) {

        this.clientRegistrationRepository.save(ClientRegistrationMapper.clientRegistrationVOtoEntity(clientRegistrationVO));

        return clientRegistrationVO;
    }

    @Override
    public SupplierRegistrationVO registerSupplier(SupplierRegistrationVO supplierRegistrationVO) {


        this.supplierRegistrationRepository.save(SupplierRegistrationMapper.supplierRegistrationVOtoEntity(supplierRegistrationVO));

        return supplierRegistrationVO;
    }
}

