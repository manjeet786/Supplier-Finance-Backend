package com.supplierfinance.domain;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="invoice",schema="public")
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_code", nullable = false, length = 50)
    private String supplierCode;

    @Column(name = "invoice_number", nullable = false, length = 50)
    private String invoiceNumber;

    @Column(name = "invoice_date", nullable = false)
    private String invoiceDate;

    @Column(name = "amount", nullable = false)
    private String amount;

    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @Column(name = "invoice_status")
    private String invoiceStatus;

    @Column(name = "file")
    @Lob
    private byte[] file;

}
