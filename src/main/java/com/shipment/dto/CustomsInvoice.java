package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomsInvoice {

    private InvoiceContact invoiceContact;
    private DutiesAndTaxes dutiesAndTaxes;
    private String currency;
    private List<InvoiceItems> invoiceItems;
    private String reasonForExport;
}
