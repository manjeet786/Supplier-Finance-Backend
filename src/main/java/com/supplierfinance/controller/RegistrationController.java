package com.supplierfinance.controller;


import com.supplierfinance.service.RegistrationService;
import com.supplierfinance.vo.ClientRegistrationVO;
import com.supplierfinance.vo.SupplierRegistrationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private RegistrationService registrationService;
    RegistrationController (RegistrationService registrationService) {
this.registrationService = registrationService;
    }

    /**This method is used to register client.
     *
     * @param clientRegistrationVO
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/client")
    ClientRegistrationVO registerClient(@ModelAttribute ClientRegistrationVO clientRegistrationVO) {
        logger.info("Value of Vo"+clientRegistrationVO);
        return registrationService.registerClient(clientRegistrationVO);
    }

    /**
     * This method is used to register Supplier.
     * @param supplierRegistrationVO
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/supplier")
    SupplierRegistrationVO registerSupplier(@ModelAttribute SupplierRegistrationVO supplierRegistrationVO) {
        logger.info("Value of Vo" + supplierRegistrationVO);
        return registrationService.registerSupplier(supplierRegistrationVO);
    }
}
