package com.supplierfinance.vo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class InvoiceUploadRequest {

    private String supplierCode;
    private String invoiceNumber;
    private String invoiceDate;
    private String amount;
    private String currency;
    private String invoiceStatus;
    private MultipartFile file;

}
