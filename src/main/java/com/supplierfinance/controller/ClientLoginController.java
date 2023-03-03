package com.supplierfinance.controller;

import com.supplierfinance.service.ClientLoginService;
import com.supplierfinance.vo.ClientLoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class ClientLoginController {

    private ClientLoginService clientLoginService;

    ClientLoginController (ClientLoginService clientLoginService) {
        this.clientLoginService = clientLoginService;
    }

    private static final Logger logger = LoggerFactory.getLogger(ClientLoginController.class);

    /** This method is used for validating client and
     * supplier login.
     *
     * @param clientLoginVO
     * @return true/false based on successful login
     */
    @PostMapping("/clientInfo")
    Boolean loginClient(@RequestBody ClientLoginVO clientLoginVO) {
        logger.info("Line 36 executed"+clientLoginVO);
        String userName = clientLoginVO.getUserName();
        String password = clientLoginVO.getPassword();
        try {
            return  this.clientLoginService.validateLogin(clientLoginVO);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
