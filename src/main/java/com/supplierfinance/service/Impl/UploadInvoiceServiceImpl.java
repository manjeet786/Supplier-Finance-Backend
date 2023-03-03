package com.supplierfinance.service.Impl;

import com.supplierfinance.domain.Invoice;
import com.supplierfinance.repository.InvoiceRepository;
import com.supplierfinance.service.UploadInvoiceService;
import com.supplierfinance.vo.InvoiceUploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UploadInvoiceServiceImpl implements UploadInvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private InvoiceRepository invoiceRepository;
    public void uploadInvoice(InvoiceUploadRequest invoiceUploadRequest) throws IOException {
        Invoice invoice = new Invoice();
        invoice.setSupplierCode(invoiceUploadRequest.getSupplierCode());
        invoice.setInvoiceNumber(invoiceUploadRequest.getInvoiceNumber());
        invoice.setInvoiceDate(invoiceUploadRequest.getInvoiceDate());
        invoice.setAmount(invoiceUploadRequest.getAmount());
        invoice.setCurrency(invoiceUploadRequest.getCurrency());
        invoice.setFile(invoiceUploadRequest.getFile().getBytes());

        invoiceRepository.save(invoice);
    }
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }


}
