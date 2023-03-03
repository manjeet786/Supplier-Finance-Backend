package com.supplierfinance.repository;

import com.supplierfinance.domain.SupplierRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRegistrationRepository extends JpaRepository<SupplierRegistration,Long> {
}
