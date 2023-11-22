package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class RateRequest implements Serializable {

    private Address from;
    private Address to;
    private String packageType;
    private List<LineItem> lineItems;
    private String unitOfMeasurement;
    private List<String> serviceOptions;
    private String shipDate;
    private String insuranceType;
    private CustomsInvoice customsInvoice;

}
