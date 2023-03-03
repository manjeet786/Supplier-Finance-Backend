package com.supplierfinance.service.Impl;

import com.supplierfinance.domain.ClientRegistration;
import com.supplierfinance.repository.ClientRegistrationRepository;
import com.supplierfinance.service.ClientLoginService;
import com.supplierfinance.service.mapper.ClientRegistrationMapper;
import com.supplierfinance.vo.ClientLoginVO;
import com.supplierfinance.vo.ClientRegistrationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientLoginServiceImpl implements ClientLoginService {

    private static final Logger logger = LoggerFactory.getLogger(ClientLoginServiceImpl.class);

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Override
    public Boolean validateLogin(ClientLoginVO clientLoginVO) {
        List<ClientRegistration> clientRegistration = new ArrayList<>();
        List<ClientRegistrationVO> clientRegistrationVOList = new ArrayList<>();

        Boolean result = false;
        clientRegistration = this.clientRegistrationRepository.findByUserNameAndPassword(clientLoginVO.getUserName(), clientLoginVO.getPassword());
        clientRegistrationVOList = clientRegistration.stream().map(ClientRegistrationMapper::clientRegistrationEntitytoVO).collect(Collectors.toList());

        for (ClientRegistrationVO clientRegistration1 : clientRegistrationVOList) {
            if (clientRegistration1.getUserName().equals(clientLoginVO.getUserName()) && clientRegistration1.getPassword().equals(clientLoginVO.getPassword())) {
                result = true;
            }
        }

        return result;
    }

}
