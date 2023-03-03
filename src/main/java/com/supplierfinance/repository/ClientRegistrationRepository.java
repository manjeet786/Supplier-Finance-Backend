package com.supplierfinance.repository;


import com.supplierfinance.domain.ClientRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRegistrationRepository extends JpaRepository<ClientRegistration,Long> {

    List<ClientRegistration> findByUserNameAndPassword(String userName,String password);

}
