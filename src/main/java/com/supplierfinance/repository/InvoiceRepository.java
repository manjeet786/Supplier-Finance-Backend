package com.supplierfinance.repository;

import com.supplierfinance.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice findByInvoiceNumber(String invoiceNumber1);
}
