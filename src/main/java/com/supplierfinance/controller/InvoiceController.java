package com.supplierfinance.controller;
import com.supplierfinance.domain.Invoice;
import com.supplierfinance.repository.InvoiceRepository;
import com.supplierfinance.service.UploadInvoiceService;
import com.supplierfinance.vo.InvoiceUploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/invoices")
public class InvoiceController {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);
    @Autowired
    private UploadInvoiceService invoiceService;

    @Autowired
    private InvoiceRepository invoiceRepository;

    /** This method is used for uploading an invoice.
     *
     * @param file
     * @param supplierCode
     * @param invoiceNumber
     * @param invoiceDate
     * @param amount
     * @param currency
     * @return
     */
    @PostMapping("/upload")
    public ResponseEntity<Void> uploadInvoice(@RequestParam("file") MultipartFile file,
                                              @RequestParam("supplierCode") String supplierCode, @RequestParam("invoiceNumber") String invoiceNumber,
                                              @RequestParam("invoiceDate")  String invoiceDate,
                                              @RequestParam("amount") String amount, @RequestParam("currency") String currency) {
        try {
            logger.info("Line 36 executed"+supplierCode);
            InvoiceUploadRequest invoiceUploadRequest = new InvoiceUploadRequest();
            invoiceUploadRequest.setSupplierCode(supplierCode);
            invoiceUploadRequest.setInvoiceNumber(invoiceNumber);
            invoiceUploadRequest.setInvoiceDate(invoiceDate);
            invoiceUploadRequest.setAmount(amount);
            invoiceUploadRequest.setCurrency(currency);
            invoiceUploadRequest.setFile(file);

            invoiceService.uploadInvoice(invoiceUploadRequest);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * This method is used to get all invoices.
     * @return
     */

    @GetMapping("/all")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        logger.info("Line 51");
        List<Invoice> invoices = invoiceService.getAllInvoices();
        logger.info("Line 53"+invoices);
        return ResponseEntity.ok().body(invoices);
    }

    /**
     * This method is used to download a file.
     * @param invoiceNumber
     * @return
     */

    @GetMapping("/{invoiceNumber}/file")
    public ResponseEntity<byte[]> downloadInvoiceFile(@PathVariable("invoiceNumber") Long invoiceNumber) {
        logger.info("Line 65");
        String invoiceNumber1 =invoiceNumber.toString();
        Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber1);
        if (invoice == null) {
            return ResponseEntity.notFound().build();
        }
        byte[] fileData = invoice.getFile(); // Assume the file data is stored as a BLOB in the 'file' column of the 'Invoice' table
        logger.info("line 73"+fileData);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "Invoice_" + invoice.getInvoiceNumber());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(fileData.length);

        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }

}

