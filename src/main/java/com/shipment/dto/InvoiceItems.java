package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvoiceItems {

    private int quantity;
    private String code;
    private String description;
    private String origin;
    private String provinceOrState;
    private int unitPrice;
    private double weight;
}
