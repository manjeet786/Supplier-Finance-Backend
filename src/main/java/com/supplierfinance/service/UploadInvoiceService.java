package com.supplierfinance.service;

import com.supplierfinance.domain.Invoice;
import com.supplierfinance.vo.InvoiceUploadRequest;

import java.io.IOException;
import java.util.List;

public interface UploadInvoiceService {

    void uploadInvoice(InvoiceUploadRequest invoiceUploadRequest) throws IOException;


    List<Invoice>  getAllInvoices();

}
